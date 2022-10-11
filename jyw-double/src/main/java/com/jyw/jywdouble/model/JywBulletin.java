package com.jyw.jywdouble.model;

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
    private Long menuId;


    /**
     * 标题
     */
    @TableField("TITLE")
    private String title;
    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;


}
