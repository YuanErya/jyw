package com.jyw.jywcommon.controller;

import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
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
    @GetMapping("/jobGuide/list")
    public ApiResult<ShowListVO<ShowSimpleVO>> ListJobGuide(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                            @RequestParam(value = "limit", defaultValue = "6") Integer limit){
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.job_guide));
    }
    @GetMapping("/newsTrends/list")
    public ApiResult<ShowListVO<ShowSimpleVO>> ListNewsTrends(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                            @RequestParam(value = "limit", defaultValue = "6") Integer limit){
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.news_trends));
    }
    @GetMapping("/workplaceActivity/list")
    public ApiResult<ShowListVO<ShowSimpleVO>> ListWorkplaceActivity(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                            @RequestParam(value = "limit", defaultValue = "6") Integer limit){
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.workplace_activity));
    }




    @GetMapping("/jobGuide/search")
    public ApiResult<ShowListVO<ShowSimpleVO>>  JobGuideSearch(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                       @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                       @RequestParam(value = "key",required =true) String key){
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.job_guide,key));
    }
    @GetMapping("/newsTrends/search")
    public ApiResult<ShowListVO<ShowSimpleVO>>  NewsTrendsSearch(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                       @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                       @RequestParam(value = "key",required =true) String key){
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.news_trends,key));
    }
    @GetMapping("/workplaceActivity/search")
    public ApiResult<ShowListVO<ShowSimpleVO>>  WorkplaceActivitySearch(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                       @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                       @RequestParam(value = "key",required =true) String key){
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.workplace_activity,key));
    }



}
