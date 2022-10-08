package com.jyw.jywcommon.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@TableName("enterprises")
@AllArgsConstructor
@NoArgsConstructor
public class Enterprise extends Common{
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     *知名企业代码为6000
     */
    private Integer type=6000;
    /**
     * 学院名
     */
    @TableField("title")
    private String title;
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
