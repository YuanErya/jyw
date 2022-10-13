package com.jyw.jywdouble.service;

import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import com.jyw.jywdouble.model.vo.DepartmentActivityDetailVO;
import com.jyw.jywdouble.model.vo.DepartmentActivityVO;

public interface IDepartmentActivityService {
    ShowListVO<DepartmentActivityVO> ListDepartmentActivity(Integer page, Integer limit, Type type,Integer departmentId);
    ShowListVO<DepartmentActivityVO> ListDepartmentActivity(Integer page, Integer limit, Type type, String key);
    ApiResult<DepartmentActivityDetailVO> GetDepartmentActivityDetail(Integer id);
}
