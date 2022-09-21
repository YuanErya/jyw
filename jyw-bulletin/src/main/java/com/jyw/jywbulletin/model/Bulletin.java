package com.jyw.jywbulletin.model;


import cn.jyw.feign.common.api.Type;
import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@TableName("bulletin")
@AllArgsConstructor
@NoArgsConstructor
public class Bulletin {
    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 公告类型
     * 3001：通知公告
     * 3002：政策法规
     */
    private Integer type;
    /**
     * 标题
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
