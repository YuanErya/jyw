package com.jyw.jywcommon.controller;

import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.jyw.jywcommon.model.Enterprise;
import com.jyw.jywcommon.model.JobGuide;
import com.jyw.jywcommon.model.NewsTrends;
import com.jyw.jywcommon.model.WorkplaceActivity;
import com.jyw.jywcommon.service.ICommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jyw/common")
public class CommonController {
    @Autowired
    private ICommonService iCommonService;

    /**
     * 就业指导的分页展示
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/jobGuide/list")
    public ApiResult<ShowListVO<ShowSimpleVO>> ListJobGuide(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                            @RequestParam(value = "limit", defaultValue = "6") Integer limit){
        return ApiResult.success(iCommonService.ListCommon(new JobGuide(),page, limit, Type.job_guide));
    }

    /**
     * 新闻动态的展示
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/newsTrends/list")
    public ApiResult<ShowListVO<ShowSimpleVO>> ListNewsTrends(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                            @RequestParam(value = "limit", defaultValue = "6") Integer limit){
        return ApiResult.success(iCommonService.ListCommon(new NewsTrends(),page, limit, Type.news_trends));
    }

    /**
     * 职场活动的展示
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/workplaceActivity/list")
    public ApiResult<ShowListVO<ShowSimpleVO>> ListWorkplaceActivity(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                            @RequestParam(value = "limit", defaultValue = "6") Integer limit){
        return ApiResult.success(iCommonService.ListCommon(new WorkplaceActivity(),page, limit, Type.workplace_activity));
    }


    /**
     * 知名企业的展示
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/wellKnownEnterprises/list")
    public ApiResult<ShowListVO<ShowSimpleVO>> ListWellKnownEnterprises(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                     @RequestParam(value = "limit", defaultValue = "6") Integer limit){
        return ApiResult.success(iCommonService.ListCommon(new Enterprise(),page, limit, Type.well_known_enterprises));
    }








    /**
     * 就业指导的检索功能
     * @param page
     * @param limit
     * @param key
     * @return
     */
    @GetMapping("/jobGuide/search")
    public ApiResult<ShowListVO<ShowSimpleVO>>  JobGuideSearch(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                       @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                       @RequestParam(value = "key",required =true) String key){
        return ApiResult.success(iCommonService.ListCommon(new JobGuide(),page, limit, Type.job_guide,key));
    }

    /**
     * 新闻动态的检索功能
     * @param page
     * @param limit
     * @param key
     * @return
     */
    @GetMapping("/newsTrends/search")
    public ApiResult<ShowListVO<ShowSimpleVO>>  NewsTrendsSearch(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                       @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                       @RequestParam(value = "key",required =true) String key){
        return ApiResult.success(iCommonService.ListCommon(new NewsTrends(),page, limit, Type.news_trends,key));
    }

    /**
     * 职场活动的检索功能
     * @param page
     * @param limit
     * @param key
     * @return
     */
    @GetMapping("/workplaceActivity/search")
    public ApiResult<ShowListVO<ShowSimpleVO>>  WorkplaceActivitySearch(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                       @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                       @RequestParam(value = "key",required =true) String key){
        return ApiResult.success(iCommonService.ListCommon(new WorkplaceActivity(),page, limit, Type.workplace_activity,key));
    }

    /**
     * 知名企业的检索功能
     * @param page
     * @param limit
     * @param key
     * @return
     */
    @GetMapping("/wellKnownEnterprises/search")
    public ApiResult<ShowListVO<ShowSimpleVO>>  WellKnownEnterprisesSearch(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                        @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                                        @RequestParam(value = "key",required =true) String key){
        return ApiResult.success(iCommonService.ListCommon(new Enterprise(),page, limit, Type.well_known_enterprises,key));
    }
}
