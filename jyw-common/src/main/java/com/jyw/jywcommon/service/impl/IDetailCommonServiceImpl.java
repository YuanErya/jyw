package com.jyw.jywcommon.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.common.api.Type;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.jyw.jywcommon.api.API;
import com.jyw.jywcommon.mapper.JywBulletinMapper;
import com.jyw.jywcommon.mapper.JywDetailMapper;
import com.jyw.jywcommon.model.JywBulletin;
import com.jyw.jywcommon.model.vo.DetailCommonVO;
import com.jyw.jywcommon.service.IDetailCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class IDetailCommonServiceImpl implements IDetailCommonService {
    @Autowired
    private JywBulletinMapper jywBulletinMapper;
    @Autowired
    private JywDetailMapper jywDetailMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 详情页
     * @param id
     * @param type
     * @return
     */
    @Override
    public ApiResult<DetailCommonVO> DetailCommon(Integer id, Type type) {
        //该值用于设置访问量的更新频率，代表多少次访问更新一次缓存
        Integer size=30;
        stringRedisTemplate.opsForValue().setIfAbsent("cache:Common:"+type.getMessage()+":"+"detail:viewCount:"+id, "0");
        String detailCommonVO = stringRedisTemplate.opsForValue().get("cache:Common:"+type.getMessage()+":"+"detail:"+id);
        if (StrUtil.isNotBlank(detailCommonVO)) {
            DetailCommonVO cache= JSON.parseObject(detailCommonVO,DetailCommonVO.class);
            stringRedisTemplate.opsForValue().increment("cache:Common:"+type.getMessage()+":"+"detail:viewCount:"+id);
            //如果访问量达到了一定的数量后删除缓存数据，同时将该处访问量同步进数据库中综合网页版的访问数据，临时缓存中的访问量清零
            if(stringRedisTemplate.opsForValue().get("cache:Common:"+type.getMessage()+":"+"detail:viewCount:"+id).equals(""+size)){
                stringRedisTemplate.opsForValue().set("cache:Common:"+type.getMessage()+":"+"detail:viewCount:"+id,"0");
                jywBulletinMapper.update(null,
                        new LambdaUpdateWrapper<JywBulletin>()
                                .eq(JywBulletin::getId,id)
                                .set(JywBulletin::getViewCount,jywBulletinMapper.selectById(id).getViewCount()+size));
                stringRedisTemplate.delete("cache:Common:"+type.getMessage()+":"+"detail:"+id);
            }
            return ApiResult.success(cache);
        }
        JywBulletin jywcommon=jywBulletinMapper.selectOne(new LambdaQueryWrapper<JywBulletin>()
                .eq(JywBulletin::getId,id)
        .eq(JywBulletin::getMenuId,API.GetTrueType(type)));
        if(jywcommon==null){
            return ApiResult.failed("暂无该id数据的"+type.getMessage());
        }
        DetailCommonVO vo = DetailCommonVO.builder()
                .id(id)
                .type(type)
                .title(jywcommon.getTitle())
                .createTime(jywcommon.getCreateTime())
                .viewCount(jywcommon.getViewCount())
                .content(jywDetailMapper.selectById(id).getContent())
                .source(jywcommon.getSource())
                .attachment(jywcommon.getAttachment())
                .build();
        stringRedisTemplate.opsForValue().set("cache:Common:"+type.getMessage()+":"+"detail:"+id, JSON.toJSONString(vo),12, TimeUnit.HOURS);
        return ApiResult.success(vo);
    }
}
