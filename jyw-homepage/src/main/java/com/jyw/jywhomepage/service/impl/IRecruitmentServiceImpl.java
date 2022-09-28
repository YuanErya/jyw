package com.jyw.jywhomepage.service.impl;

import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyw.jywhomepage.mapper.RecruitmentMapper;
import com.jyw.jywhomepage.model.Recruitment;
import com.jyw.jywhomepage.service.IRecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IRecruitmentServiceImpl extends ServiceImpl<RecruitmentMapper,Recruitment> implements IRecruitmentService {
   @Autowired
   private RecruitmentMapper recruitmentMapper;

    @Override
    public ShowListVO<ShowSimpleVO> listRecruitment(Integer page, Integer limit, Integer type) {
        ShowListVO<ShowSimpleVO> show=new ShowListVO<ShowSimpleVO>();
        LambdaQueryWrapper<Recruitment> lqw=new LambdaQueryWrapper<>();
        lqw.eq(Recruitment::getType,type);
        Page<Recruitment> plist=new Page<Recruitment>(page,limit);
        recruitmentMapper.selectPage(plist,lqw);
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
            vo.setType(plist.getRecords().get(i).getType().equals(Type.homepage_recruitment_work.getCode())? Type.homepage_recruitment_work:Type.homepage_recruitment_internship);
            vo.setTitle(plist.getRecords().get(i).getTitle());
            vo.setCreateTime(plist.getRecords().get(i).getCreateTime());
            list.add(vo);
        }
        show.setList(list);
        return show;
    }
}
