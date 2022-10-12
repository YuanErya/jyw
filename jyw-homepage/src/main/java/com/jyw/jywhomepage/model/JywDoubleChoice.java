package com.jyw.jywhomepage.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("BASE_DOUBLE_CHOICE")
@AllArgsConstructor
@NoArgsConstructor
public class JywDoubleChoice {

    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 年份
     */
    @TableField("YEAR")
    private String year;

    /**
     * 标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 地址
     */
    @TableField("ADDRESS")
    private String address;

    /**
     * 开始的时间点
     */
    @JSONField(format="HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    @TableField(value = "START_TIME", fill = FieldFill.INSERT)
    private Date startTime;

    /**
     * 结束的时间点
     */
    @JSONField(format="HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    @TableField(value = "END_TIME", fill = FieldFill.INSERT)
    private Date endTime;

    /**
     * 开始报名的时间点
     */
    @JSONField(format="yyyy-MM-dd  HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @TableField(value = "APPLY_START_TIME", fill = FieldFill.INSERT)
    private Date applyStartTime;

    /**
     * 报名结束的时间点
     */
    @JSONField(format="yyyy-MM-dd  HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @TableField(value = "APPLY_END_TIME", fill = FieldFill.INSERT)
    private Date applyEndTime;

    /**
     * 发布的时间点
     */
    @JSONField(format="yyyy-MM-dd  HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    @TableField(value = "PUBLISH_TIME", fill = FieldFill.INSERT)
    private Date publishTime;
    /**
     * 展位图id
     */
    @TableField("BOOTH_IMG_ID")
    private  Long boothImgId;

    /**
     * 展位图url
     */
    @TableField("BOOTH_IMG_URL")
    private String boothImgUrl;
    /**
     * 浏览量
     */
    @TableField("VIEW_COUNT")
    private  Long viewCount;


    /**
     * 是否删除，结果有
     * 删除
     * 未删除
     */
    @TableField("DICT_DELETED_NAME")
    private String dictDeletedName;
}
