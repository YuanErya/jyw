package com.jyw.jywcommon.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jyw.jywcommon.api.API;
import com.jyw.jywcommon.mapper.*;
import com.jyw.jywcommon.model.*;
import com.jyw.jywcommon.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class ICommonServiceImpl implements ICommonService {
    @Autowired
    private JywBulletinMapper jywBulletinMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 综合搜索
     * @param page
     * @param limit
     * @param key
     * @return
     */
    @Override
    public ShowListVO<ShowSimpleVO> AllSearch(Integer page, Integer limit, String key) {
        String showListShowVO = stringRedisTemplate.opsForValue().get("cache:Common:all:search:"+page+","+limit+","+key);
        if (StrUtil.isNotBlank(showListShowVO)) {
            return JSON.parseObject(showListShowVO, new TypeReference<ShowListVO<ShowSimpleVO>>(){});
        }
        ShowListVO<ShowSimpleVO> show = new ShowListVO<ShowSimpleVO>();
        Page<JywBulletin> List = new Page<JywBulletin>(page, limit);
        LambdaQueryWrapper<JywBulletin> lqw = new LambdaQueryWrapper<>();
        lqw.like(JywBulletin::getTitle, key);
        lqw.orderByDesc(JywBulletin::getCreateTime);//按时间排序
        lqw.orderByAsc(JywBulletin::getId);//时间相同则按照id进行排序
        jywBulletinMapper.selectPage(List, lqw);
        GetShowList(List, null, show);
        //缓存10分钟
        stringRedisTemplate.opsForValue().set("cache:Common:all:search:"+page+","+limit+","+key, JSON.toJSONString(show),10, TimeUnit.MINUTES);
        return show;
    }

    /**
     * 分页展示的相似的数据
     * 通过泛型减少了一定的代码重复
     * 如果增加新的相似的功能则在if分支中增加即可，下方重载的（检索）方法也要添加
     *
     * @param page
     * @param limit
     * @param type
     * @param
     * @return
     */
    public ShowListVO<ShowSimpleVO> ListCommon(Integer page, Integer limit, Type type) {
        String showListShowVO = stringRedisTemplate.opsForValue().get("cache:Common:"+type.getMessage()+":"+"list:"+page+","+limit);
        if (StrUtil.isNotBlank(showListShowVO)) {
            return JSON.parseObject(showListShowVO, new TypeReference<ShowListVO<ShowSimpleVO>>(){});
        }
        ShowListVO<ShowSimpleVO> show = new ShowListVO<ShowSimpleVO>();
        Page<JywBulletin> List = new Page<JywBulletin>(page, limit);
        LambdaQueryWrapper<JywBulletin> lqw = new LambdaQueryWrapper<>();
        lqw.eq(JywBulletin::getMenuId, API.GetTrueType(type));
        lqw.orderByDesc(JywBulletin::getCreateTime);//按时间排序
        lqw.orderByAsc(JywBulletin::getId);//时间相同则按照id进行排序
        jywBulletinMapper.selectPage(List, lqw);
        GetShowList(List, type, show);
        stringRedisTemplate.opsForValue().set("cache:Common:"+type.getMessage()+":"+"list:"+page+","+limit, JSON.toJSONString(show),10, TimeUnit.MINUTES);
        return show;
    }

    /**
     * 重载上面的方法
     * 的有key参数传入 进行检索查询
     *
     * @param
     * @param page
     * @param limit
     * @param type
     * @param key
     * @return
     */
    @Override
    public ShowListVO<ShowSimpleVO> ListCommon(Integer page, Integer limit, Type type, String key) {
        String showListShowVO = stringRedisTemplate.opsForValue().get("cache:Common:"+type.getMessage()+":"+"list:"+page+","+limit+","+key);
        if (StrUtil.isNotBlank(showListShowVO)) {
            return JSON.parseObject(showListShowVO, new TypeReference<ShowListVO<ShowSimpleVO>>(){});
        }
        ShowListVO<ShowSimpleVO> show = new ShowListVO<>();
        Page<JywBulletin> List = new Page<JywBulletin>(page, limit);
        LambdaQueryWrapper<JywBulletin> lqw = new LambdaQueryWrapper<>();
        lqw.eq(JywBulletin::getMenuId, API.GetTrueType(type));
        if (type.equals(Type.bulletin)) {
            lqw.eq(JywBulletin::getMenuId, API.GetTrueType(type)).or().eq(JywBulletin::getMenuId, API.GetTrueType(Type.bulletin_policy));
        }
        lqw.like(JywBulletin::getTitle, key);
        lqw.orderByDesc(JywBulletin::getCreateTime);//按时间排序
        lqw.orderByAsc(JywBulletin::getId);//时间相同则按照id进行排序
        jywBulletinMapper.selectPage(List, lqw);
        GetShowList(List, type, show);
        stringRedisTemplate.opsForValue().set("cache:Common:"+type.getMessage()+":"+"list:"+page+","+limit+","+key, JSON.toJSONString(show),10, TimeUnit.MINUTES);
        return show;
    }

    /**
     * 用于装配，
     * 将实体类转化为用于展示的简化版的对象
     *
     * @param List
     * @param type
     * @param show
     * @return
     */
    private ShowListVO<ShowSimpleVO> GetShowList(Page<JywBulletin> List, Type type, ShowListVO<ShowSimpleVO> show) {
        if(type!=null){
            show.setType(type.getMessage());
        }
        show.setTotalCount(List.getTotal());
        show.setPageSize(List.getSize());
        show.setTotalPage(List.getPages());
        show.setCurrPage(List.getCurrent());
        List<ShowSimpleVO> list = new ArrayList<ShowSimpleVO>();
        for (int i = 0; i < List.getRecords().size(); i++) {
            ShowSimpleVO vo = new ShowSimpleVO();
            vo.setId(List.getRecords().get(i).getId());
            vo.setType(API.GetType(List.getRecords().get(i).getMenuId()));
            vo.setTitle(List.getRecords().get(i).getTitle());
            vo.setCreateTime(List.getRecords().get(i).getCreateTime());
            list.add(vo);
        }
        show.setList(list);
        return show;
    }
}
