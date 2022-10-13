package com.jyw.jywcommon.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.common.api.Type;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
        String detailCommonVO = stringRedisTemplate.opsForValue().get("cache:Common:"+type.getMessage()+":"+"detail:"+id);
        if (StrUtil.isNotBlank(detailCommonVO)) {
            DetailCommonVO cache= JSON.parseObject(detailCommonVO,DetailCommonVO.class);
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
        stringRedisTemplate.opsForValue().set("cache:Common:"+type.getMessage()+":"+"detail:"+id, JSON.toJSONString(vo),30, TimeUnit.MINUTES);
        return ApiResult.success(vo);
    }
}
