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
//该控制层主要是写的分页展示
@RestController
@RequestMapping("/jyw/common")
public class GetCommonController {
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
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.job_guide));
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
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.news_trends));
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
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.workplace_activity));
    }


    /**
     * 通知和政策的展示
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("bulletin/list")
    public ApiResult<ShowListVO<ShowSimpleVO>> ShowList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                        @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                        @RequestParam(value = "type", required = true) Integer type) {
        if (type != 3001 && type != 3002) {
            return ApiResult.failed("请校验类型参数");
        }return ApiResult.success(iCommonService.ListCommon(page, limit,
                type.equals(Type.bulletin_announcement.getCode())?Type.bulletin_announcement:Type.bulletin_policy));
    }

    /**
     * 校招指南的展示
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/schoolRecruitmentGuide/list")
    public ApiResult<ShowListVO<ShowSimpleVO>> ListSchoolRecruitmentGuide(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                        @RequestParam(value = "limit", defaultValue = "6") Integer limit){
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.school_recruitment_guide));
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
        return ApiResult.success(iCommonService.ListCommon(page, limit, Type.well_known_enterprises));
    }
}
