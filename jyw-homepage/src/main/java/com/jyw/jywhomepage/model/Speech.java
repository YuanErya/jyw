package com.jyw.jywhomepage.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("speech")
@AllArgsConstructor
@NoArgsConstructor
public class Speech {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     *实习为1003
     *招聘代码为1001
     */
    private Integer type;
    /**
     * 标题
     */
    @TableField("title")
    private String title;
    /**
     * 地址
     */
    @TableField("address")
    private String address;
    /**
     * 开始的日期
     */
    @JSONField(format="yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @TableField(value = "start_date", fill = FieldFill.INSERT)
    private Date startDate;
    /**
     * 开始的时间点
     */
    @JSONField(format="HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    @TableField(value = "start_time", fill = FieldFill.INSERT)
    private Date startTime;
    /**
     * 结束的时间点
     */
    @JSONField(format="HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    @TableField(value = "end_time", fill = FieldFill.INSERT)
    private Date endTime;
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
