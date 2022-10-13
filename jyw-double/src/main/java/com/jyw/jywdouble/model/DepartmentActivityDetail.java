package com.jyw.jywdouble.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("BASE_COLLEGE_INFO_BLOB")
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentActivityDetail {
    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 学院活动ID
     */
    @TableField("BASE_COLLEGE_INFO_ID")
    private String BaseCollegeInfoId;

    /**
     * 内容
     */
    @TableField("CONTENT")
    private String content;
}
