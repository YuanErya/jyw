package com.jyw.jywhomepage.controller;

import cn.jyw.feign.common.api.ApiResult;
import com.jyw.jywhomepage.model.vo.RecruitmentDetailVO;
import com.jyw.jywhomepage.service.IRecruitmentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jyw/homepage")
public class RecruitmentDetailController {
    @Autowired
    private IRecruitmentDetailService iRecruitmentDetailService;

    /**
     * 招聘的详情页
     * @param id
     * @return
     */
    @GetMapping("/recruitment/detail")
    public ApiResult<RecruitmentDetailVO> GetPreachMeetingDetail(@RequestParam(value = "id", required = true) Integer id) {
        return iRecruitmentDetailService.GetRecruitmentDetail(id);
    }

}
