package com.jyw.jywcommon.model;


import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("department")
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     *学院风采代码为2000
     */
    private Integer type=8000;
    /**
     * 学院名
     */
    @TableField("name")
    private String name;
    /**
     * 内容
     */
    @TableField("content")
    private String content;
    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "create_time", fill = FieldFill.INSERT)
    private Date createTime;

}
