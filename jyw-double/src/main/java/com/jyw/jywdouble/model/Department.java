package com.jyw.jywdouble.model;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("DICT_COLLEGE_20180119")
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 学院名
     */
    @TableField("NAME")
    private String name;
    /**
     * 学院代码
     */
    @TableField("CODE")
    private String code;


}
