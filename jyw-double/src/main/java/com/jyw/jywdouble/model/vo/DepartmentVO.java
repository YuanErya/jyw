package com.jyw.jywdouble.model.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//用于分页展示学院的简化信息
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentVO {
    /**
     * 学院id
     */
    private  Integer id;
    /**
     * 学院名字
     */
    private String name;

}
