package com.jyw.jywhomepage.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyw.jywhomepage.mapper.JywRecruitmentMapper;
import com.jyw.jywhomepage.model.JywRecruitment;
import com.jyw.jywhomepage.service.IRecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class IRecruitmentServiceImpl extends ServiceImpl<JywRecruitmentMapper,JywRecruitment> implements IRecruitmentService {
    @Autowired
    private JywRecruitmentMapper jywRecruitmentMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public ShowListVO<ShowSimpleVO> listRecruitment(Integer page, Integer limit, Integer type) {
        String showListShowVO = stringRedisTemplate.opsForValue().get("cache:Homepage:"+type+":"+"list:"+page+","+limit);
        if (StrUtil.isNotBlank(showListShowVO)) {
            return JSON.parseObject(showListShowVO, new TypeReference<ShowListVO<ShowSimpleVO>>(){});
        }
        ShowListVO<ShowSimpleVO> show=new ShowListVO<ShowSimpleVO>();
        LambdaQueryWrapper<JywRecruitment> lqw=new LambdaQueryWrapper<>();
        lqw.eq(JywRecruitment::getDictRecruitmentTypeName,
                type.equals(Type.homepage_recruitment_work.getCode())?
                        "招聘":"实习")//判断查询招聘还是实习
        .eq(JywRecruitment::getDictDeletedName,"未删除");//判断该条数据是否审核通过
        lqw.orderByDesc(JywRecruitment::getPublishTime);//按时间排序
        lqw.orderByAsc(JywRecruitment::getId);//时间相同则按照id进行排序
        Page<JywRecruitment> plist=new Page<JywRecruitment>(page,limit);
        jywRecruitmentMapper.selectPage(plist,lqw);
        show.setType(type.equals(Type.homepage_recruitment_work.getCode())?Type.homepage_recruitment_work.getMessage():Type.homepage_recruitment_internship.getMessage());
        show.setTotalCount(plist.getTotal());
        show.setPageSize(plist.getSize());
        show.setTotalPage(plist.getPages());
        show.setCurrPage(plist.getCurrent());
        List<ShowSimpleVO> list=new ArrayList<ShowSimpleVO>();
        //将Bulltin简化为分页展示的格式，及省去了具体内容
        for (int i = 0; i < plist.getRecords().size(); i++) {
            ShowSimpleVO vo=new ShowSimpleVO();
            vo.setId(plist.getRecords().get(i).getId());
            vo.setType(plist.getRecords().get(i).getDictRecruitmentTypeValue().equals(new Long("5020050000000002"))? Type.homepage_recruitment_work:Type.homepage_recruitment_internship);
            vo.setTitle(plist.getRecords().get(i).getTitle());
            vo.setCreateTime(plist.getRecords().get(i).getPublishTime());//实际这里的时间是审核通过的时间
            list.add(vo);
        }
        show.setList(list);
        stringRedisTemplate.opsForValue().set("cache:Homepage:"+type+":"+"list:"+page+","+limit, JSON.toJSONString(show),10, TimeUnit.MINUTES);
        return show;
    }
}
