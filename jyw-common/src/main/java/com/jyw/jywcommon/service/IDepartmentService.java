package com.jyw.jywcommon.service;

import cn.jyw.feign.model.vo.ShowListVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jyw.jywcommon.model.Department;
import com.jyw.jywcommon.model.vo.DepartmentVO;

public interface IDepartmentService extends IService<Department> {
    ShowListVO<DepartmentVO> showList(Integer page, Integer limit);
}
