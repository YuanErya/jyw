package com.jyw.jywcommon.service.impl;

import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jyw.jywcommon.mapper.*;
import com.jyw.jywcommon.model.*;
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
    @Autowired
    private EnterpriseMapper enterpriseMapper;
    @Autowired
    private RecruitmentGuideMapper recruitmentMapper;

    @Autowired
    private JywBulletinMapper jywBulletinMapper;

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
    public  ShowListVO<ShowSimpleVO> ListCommon(Integer page, Integer limit, Type type) {

        ShowListVO<ShowSimpleVO> show = new ShowListVO<ShowSimpleVO>();
            Page<JywBulletin> List = new Page<JywBulletin>(page, limit);
            LambdaQueryWrapper<JywBulletin> lqw = new LambdaQueryWrapper<>();
            lqw.eq(JywBulletin::getMenuId,GetTrueType(type));
            lqw.orderByDesc(JywBulletin::getCreateTime);//按时间排序
            lqw.orderByAsc(JywBulletin::getId);//时间相同则按照id进行排序
            jywBulletinMapper.selectPage(List, lqw);
            return GetShowList(List, type, show);
    }

    /**
     * 重载上面的方法
     * 的有key参数传入 进行检索查询
     * @param t
     * @param page
     * @param limit
     * @param type
     * @param key
     * @param <T>
     * @return
     */
    @Override
    public <T extends Common> ShowListVO<ShowSimpleVO> ListCommon(T t, Integer page, Integer limit, Type type, String key) {
        ShowListVO<ShowSimpleVO> show = new ShowListVO<ShowSimpleVO>();
        if (t instanceof JobGuide) {
            Page<JobGuide> List = new Page<JobGuide>(page, limit);
            jobGuideMapper.selectPage(List, new LambdaQueryWrapper<JobGuide>()
                    .like(JobGuide::getTitle, key)
                    .or().like(JobGuide::getContent, key));
            return GetShowList(List, type, show);
        } else if (t instanceof NewsTrends) {
            Page<NewsTrends> List = new Page<NewsTrends>(page, limit);
            newsTrendsMapper.selectPage(List, new LambdaQueryWrapper<NewsTrends>()
                    .like(NewsTrends::getTitle, key)
                    .or().like(NewsTrends::getContent, key));
            return GetShowList(List, type, show);
        } else if (t instanceof WorkplaceActivity) {
            Page<WorkplaceActivity> List = new Page<WorkplaceActivity>(page, limit);
            workplaceActivityMapper.selectPage(List, new LambdaQueryWrapper<WorkplaceActivity>()
                    .like(WorkplaceActivity::getTitle, key)
                    .or().like(WorkplaceActivity::getContent, key));
            return GetShowList(List, type, show);
        }else if (t instanceof Enterprise) {
            Page<Enterprise> List = new Page<Enterprise>(page, limit);
            enterpriseMapper.selectPage(List, new LambdaQueryWrapper<Enterprise>()
                    .like(Enterprise::getTitle, key)
                    .or().like(Enterprise::getContent, key));
            return GetShowList(List, type, show);
        }else if (t instanceof RecruitmentGuide) {
            Page<RecruitmentGuide> List = new Page<RecruitmentGuide>(page, limit);
            recruitmentMapper.selectPage(List, new LambdaQueryWrapper<RecruitmentGuide>()
                    .like(RecruitmentGuide::getTitle, key)
                    .or().like(RecruitmentGuide::getContent, key));
            return GetShowList(List, type, show);
        }
        return null;
    }

    /**
     * 用于装配，
     * 将实体类转化为用于展示的简化版的对象
     * @param List
     * @param type
     * @param show
     * @return
     */
    private ShowListVO<ShowSimpleVO> GetShowList(Page<? extends Common> List, Type type, ShowListVO<ShowSimpleVO> show) {
        show.setType(type.getMessage());
        show.setTotalCount(List.getTotal());
        show.setPageSize(List.getSize());
        show.setTotalPage(List.getPages());
        show.setCurrPage(List.getCurrent());
        List<ShowSimpleVO> list = new ArrayList<ShowSimpleVO>();
        for (int i = 0; i < List.getRecords().size(); i++) {
            ShowSimpleVO vo = new ShowSimpleVO();
            vo.setId(List.getRecords().get(i).getId());
            vo.setType(type);
            vo.setTitle(List.getRecords().get(i).getTitle());
            vo.setCreateTime(List.getRecords().get(i).getCreateTime());
            list.add(vo);
        }
        show.setList(list);
        return show;
    }

    /**
     * 返回查询时的真是原数据库表中的真实ID
     * @param type
     * @return
     */
    private  Integer GetTrueType(Type type){
        Integer trueType=0;
        switch (type.getCode()){
            case 2000:
                trueType =40;
                break;
            case 4000:
                trueType =100;
                break;
            case 5000:
                trueType =90;
                break;
            case 7000:
                trueType =110;
                break;
        }
return trueType;
    }
}
