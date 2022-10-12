package com.jyw.jywcommon.controller;

import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.common.api.Type;
import com.jyw.jywcommon.model.vo.DetailCommonVO;
import com.jyw.jywcommon.service.IDetailCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
//该控制层用于展示详情
@RestController
@RequestMapping("/jyw/common")
public class DetailCommonController {
    @Autowired
    private IDetailCommonService iDetailCommonService;

    /**
     * 就业指导的详情页
     * @param id
     * @return
     */
    @GetMapping("/jobGuide/detail")
    public ApiResult<DetailCommonVO> DetailJobGuide(@RequestParam(value = "id",required =true) Integer id){
        return iDetailCommonService.DetailCommon(id, Type.job_guide);
    }

    /**
     * 新闻动态的详情页
     * @param id
     * @return
     */
    @GetMapping("/newsTrends/detail")
    public ApiResult<DetailCommonVO> DetailNewsTrends(@RequestParam(value = "id",required =true) Integer id){
        return iDetailCommonService.DetailCommon(id, Type.news_trends);
    }

    /**
     * 职场活动的详情页
     * @param id
     * @return
     */
    @GetMapping("/workplaceActivity/detail")
    public ApiResult<DetailCommonVO> DetailWorkplaceActivity(@RequestParam(value = "id",required =true) Integer id){
        return iDetailCommonService.DetailCommon(id, Type.workplace_activity);
    }
    /**
     * 通知的详情页
     * @param id
     * @return
     */
    @GetMapping("/bulletin/announcement/detail")
    public ApiResult<DetailCommonVO> DetailBulletinAnnouncement(@RequestParam(value = "id",required =true) Integer id){
        return iDetailCommonService.DetailCommon(id, Type.bulletin_announcement);
    }
    /**
     * 政策的详情页
     * @param id
     * @return
     */
    @GetMapping("/bulletin/policy/detail")
    public ApiResult<DetailCommonVO> DetailBulletinPolicy(@RequestParam(value = "id",required =true) Integer id){
        return iDetailCommonService.DetailCommon(id, Type.bulletin_policy);
    }

    /**
     * 校招指南的详情页
     * @param id
     * @return
     */
    @GetMapping("/schoolRecruitmentGuide/detail")
    public ApiResult<DetailCommonVO> DetailSchoolRecruitmentGuide(@RequestParam(value = "id",required =true) Integer id){
        return iDetailCommonService.DetailCommon(id, Type.school_recruitment_guide);
    }

    /**
     * 知名企业的详情页
     * @param id
     * @return
     */
    @GetMapping("/wellKnownEnterprises/detail")
    public ApiResult<DetailCommonVO> DetailWellKnownEnterprises(@RequestParam(value = "id",required =true) Integer id){
        return iDetailCommonService.DetailCommon(id, Type.well_known_enterprises);
    }
}
