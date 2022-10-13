package com.jyw.jywdouble.controller;



import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import com.jyw.jywdouble.model.vo.DepartmentActivityDetailVO;
import com.jyw.jywdouble.model.vo.DepartmentActivityVO;
import com.jyw.jywdouble.model.vo.DepartmentVO;
import com.jyw.jywdouble.service.IDepartmentActivityService;
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
    @Autowired
    private IDepartmentActivityService iDepartmentActivityService;

    /**
     * 学院的分页展示
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/department/list")
    public ApiResult<ShowListVO<DepartmentVO>> ListDepartment(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                              @RequestParam(value = "limit", defaultValue = "6") Integer limit) {

        return ApiResult.success(iDepartmentService.showList(page, limit));
    }
    /**
     * 学院活动的分页展示
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/department/activity/list")
    public ApiResult<ShowListVO<DepartmentActivityVO>> ListDepartmentActivity(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                              @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                                              @RequestParam(value = "id",required =true) Integer departmentId) {

        return ApiResult.success(iDepartmentActivityService.ListDepartmentActivity(page, limit, Type.departments_introduce,departmentId));
    }

    /**
     * 学院活动d的详情
     * @return
     */
    @GetMapping("/department/activity/detail")
    public ApiResult<DepartmentActivityDetailVO> DetailDepartmentActivity(@RequestParam(value = "id",required =true) Integer id) {

        return iDepartmentActivityService.GetDepartmentActivityDetail(id);
    }



}
