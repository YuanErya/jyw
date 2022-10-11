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
//该控制层用于检索
@RestController
@RequestMapping("/jyw/common")
public class SearchCommonController {
    @Autowired
    private ICommonService iCommonService;

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
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.job_guide,key));
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
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.news_trends,key));
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
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.workplace_activity,key));
    }

    /**
     * 关键字搜索
     *
     * @param page
     * @param limit
     * @param key   关键字
     * @return
     */
    @GetMapping("/bulletin/search")
    public ApiResult<ShowListVO<ShowSimpleVO>> Search(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                      @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                      @RequestParam(value = "key", required = true) String key) {
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.bulletin ,key));
    }

    /**
     * 校招指南的检索功能
     * @param page
     * @param limit
     * @param key
     * @return
     */
    @GetMapping("/schoolRecruitmentGuide/search")
    public ApiResult<ShowListVO<ShowSimpleVO>>  SchoolRecruitmentGuideSearch(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                             @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                                             @RequestParam(value = "key",required =true) String key){
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.school_recruitment_guide,key));
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
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.well_known_enterprises,key));
    }
}
