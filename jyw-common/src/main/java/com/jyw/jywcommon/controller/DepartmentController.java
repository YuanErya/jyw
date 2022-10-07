package com.jyw.jywcommon.controller;

import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.model.vo.ShowListVO;
import com.jyw.jywcommon.model.vo.DepartmentVO;
import com.jyw.jywcommon.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jyw/common")
public class DepartmentController {
    @Autowired
    private IDepartmentService iDepartmentService;

    @GetMapping("/department/list")
    public ApiResult<ShowListVO<DepartmentVO>> ListDepartment(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                              @RequestParam(value = "limit", defaultValue = "6") Integer limit) {

        return ApiResult.success(iDepartmentService.showList(page, limit));
    }
}
