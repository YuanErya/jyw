package com.jyw.jywdouble.controller;



import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.model.vo.ShowListVO;
import com.jyw.jywdouble.model.vo.DepartmentVO;
import com.jyw.jywdouble.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/jyw/double")
public class DoubleController {

    @Autowired
    private IDepartmentService iDepartmentService;

    @GetMapping("/department/list")
    public ApiResult<ShowListVO<DepartmentVO>> ListDepartment(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                              @RequestParam(value = "limit", defaultValue = "6") Integer limit) {

        return ApiResult.success(iDepartmentService.showList(page, limit));
    }


}
