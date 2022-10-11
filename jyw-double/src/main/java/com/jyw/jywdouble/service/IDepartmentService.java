package com.jyw.jywdouble.service;


import cn.jyw.feign.model.vo.ShowListVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jyw.jywdouble.model.Department;
import com.jyw.jywdouble.model.vo.DepartmentVO;

public interface IDepartmentService extends IService<Department> {
    ShowListVO<DepartmentVO> showList(Integer page, Integer limit);
}
