package com.jyw.jywcommon.service.impl;


import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jyw.jywcommon.mapper.JobGuideMapper;
import com.jyw.jywcommon.mapper.NewsTrendsMapper;
import com.jyw.jywcommon.mapper.WorkplaceActivityMapper;
import com.jyw.jywcommon.model.JobGuide;
import com.jyw.jywcommon.model.NewsTrends;
import com.jyw.jywcommon.model.WorkplaceActivity;
import com.jyw.jywcommon.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ICommonServiceImpl implements ICommonService {
    @Autowired
    private JobGuideMapper jobGuideMapper;
    @Autowired
    private NewsTrendsMapper newsTrendsMapper;
    @Autowired
    private WorkplaceActivityMapper workplaceActivityMapper;

    public ShowListVO<ShowSimpleVO> ListCommon(Integer page, Integer limit,Type type){
        ShowListVO<ShowSimpleVO> show=new ShowListVO<ShowSimpleVO>();
        return GetShowList(page, limit, type,show,null);
    }

    public ShowListVO<ShowSimpleVO> ListCommon(Integer page, Integer limit,Type type,String key){
        ShowListVO<ShowSimpleVO> show=new ShowListVO<ShowSimpleVO>();
        return GetShowList(page, limit, type,show,key);
    }





    private ShowListVO<ShowSimpleVO> GetShowList(Integer page, Integer limit, Type type,ShowListVO<ShowSimpleVO> show,String key){
        switch(type.getCode()){
            case 2000:
                Page<JobGuide> jobList=new Page<JobGuide>(page,limit);
                if(key!=null){
                    LambdaQueryWrapper<JobGuide> lqwJob=new LambdaQueryWrapper<>();
                    //根据KEY对标题和内容均进行匹配
                    lqwJob.like(JobGuide::getTitle,key).or().like(JobGuide::getContent,key);
                    jobGuideMapper.selectPage(jobList,lqwJob);
                }else{ jobGuideMapper.selectPage(jobList,null);}
                show.setType(type.getMessage());
                show.setTotalCount(jobList.getTotal());
                show.setPageSize(jobList.getSize());
                show.setTotalPage(jobList.getPages());
                show.setCurrPage(jobList.getCurrent());
                List<ShowSimpleVO> list=new ArrayList<ShowSimpleVO>();
                for (int i = 0; i < jobList.getRecords().size(); i++) {
                    ShowSimpleVO vo=new ShowSimpleVO();
                    vo.setId(jobList.getRecords().get(i).getId());
                    vo.setType(type);
                    vo.setTitle(jobList.getRecords().get(i).getTitle());
                    vo.setCreateTime(jobList.getRecords().get(i).getCreateTime());
                    list.add(vo);
                }
                show.setList(list);
                return show;
            case 4000:
                Page<WorkplaceActivity> workList=new Page<WorkplaceActivity>(page,limit);
                if(key!=null){
                    LambdaQueryWrapper<WorkplaceActivity> lqwWorkplace=new LambdaQueryWrapper<>();
                    //根据KEY对标题和内容均进行匹配
                    lqwWorkplace.like(WorkplaceActivity::getTitle,key).or().like(WorkplaceActivity::getContent,key);
                    workplaceActivityMapper.selectPage(workList,lqwWorkplace);
                }else{workplaceActivityMapper.selectPage(workList,null);}
                show.setType(type.getMessage());
                show.setTotalCount(workList.getTotal());
                show.setPageSize(workList.getSize());
                show.setTotalPage(workList.getPages());
                show.setCurrPage(workList.getCurrent());
                List<ShowSimpleVO> list1=new ArrayList<ShowSimpleVO>();
                for (int i = 0; i < workList.getRecords().size(); i++) {
                    ShowSimpleVO vo=new ShowSimpleVO();
                    vo.setId(workList.getRecords().get(i).getId());
                    vo.setType(type);
                    vo.setTitle(workList.getRecords().get(i).getTitle());
                    vo.setCreateTime(workList.getRecords().get(i).getCreateTime());
                    list1.add(vo);
                }
                show.setList(list1);
                return show;
            case 5000:
                Page<NewsTrends> newsList=new Page<NewsTrends>(page,limit);
                if(key!=null){
                    LambdaQueryWrapper<NewsTrends> lqwNews=new LambdaQueryWrapper<>();
                    //根据KEY对标题和内容均进行匹配
                    lqwNews.like(NewsTrends::getTitle,key).or().like(NewsTrends::getContent,key);
                   newsTrendsMapper.selectPage(newsList,lqwNews);
                }else{newsTrendsMapper.selectPage(newsList,null);}
                show.setType(type.getMessage());
                show.setTotalCount(newsList.getTotal());
                show.setPageSize(newsList.getSize());
                show.setTotalPage(newsList.getPages());
                show.setCurrPage(newsList.getCurrent());
                List<ShowSimpleVO> list2=new ArrayList<ShowSimpleVO>();
                for (int i = 0; i < newsList.getRecords().size(); i++) {
                    ShowSimpleVO vo=new ShowSimpleVO();
                    vo.setId(newsList.getRecords().get(i).getId());
                    vo.setType(type);
                    vo.setTitle(newsList.getRecords().get(i).getTitle());
                    vo.setCreateTime(newsList.getRecords().get(i).getCreateTime());
                    list2.add(vo);
                }
                show.setList(list2);
                return show;
        }
        return null;
    }
}
