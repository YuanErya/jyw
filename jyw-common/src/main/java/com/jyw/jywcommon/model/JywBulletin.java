package com.jyw.jywcommon.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("BASE_BULLETIN_INFO")
@AllArgsConstructor
@NoArgsConstructor
public class JywBulletin {
    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;


    /**
     * 类型ID
     */
    @TableField("MENU_ID")
    private Integer menuId;


    /**
     * 标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 信息来源
     */
    @TableField("SOURCE")
    private String source;
    /**
     * 附件
     */
    @TableField("ATTACHMENT")
    private String attachment;

    /**
     * 浏览量
     */
    @TableField("VIEW_COUNT")
    private  Integer viewCount;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;


}
