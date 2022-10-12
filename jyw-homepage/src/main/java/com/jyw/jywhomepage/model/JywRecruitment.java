package com.jyw.jywhomepage.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("BASE_RECRUITMENT")
@AllArgsConstructor
@NoArgsConstructor
public class JywRecruitment {
    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 雇主id
     */
    @TableField("ENTERPRISE_ID")
    private Integer enterpriseId;
    /**
     * 雇主名称
     */
    @TableField("ENTERPRISE_NAME")
    private String enterpriseName;
    /**
     * 发布时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "PUBLISH_TIME", fill = FieldFill.INSERT)
    private Date publishTime;

    /**
     * 招聘类型的代码
     * 5020050000000001实习
     * 5020050000000002招聘
     */
    @TableField("DICT_RECRUITMENT_TYPE_VALUE")
    private Long dictRecruitmentTypeValue;

    /**
     * 招聘类型
     * 招聘
     * 实习
     */
    @TableField("DICT_RECRUITMENT_TYPE_NAME")
    private String dictRecruitmentTypeName;

    /**
     * 标签
     */
    @TableField("TAGS")
    private String tags;
    /**
     * 简历投递开始时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "RESUME_DELIVERY_START_TIME", fill = FieldFill.INSERT)
    private Date resumeDeliveryStartTime;

    /**
     * 简历投递结束时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "RESUME_DELIVERY_END_TIME", fill = FieldFill.INSERT)
    private Date resumeDeliveryEndTime;
    /**
     * 简历接收邮箱
     */
    @TableField("RESUME_DELIVERY_EMAIL")
    private String resumeDeliveryEmail;

    /**
     * 工作地点
     */
    @TableField("WORKPLACE")
    private String workplace;

    /**
     * 简历 接收方式
     */
    @TableField("DICT_RESUME_RECEIVE_NAME")
    private String dictResumeReceiveName;

    /**
     * 网申地址
     */
    @TableField("ONLINE_APPLICATION")
    private String onlineApplication;

    /**
     * 访问量
     */
    @TableField("BROWSE_NUMBER")
    private Long browseNumber;

    /**
     * 是否删除
     * 结果有：
     * 删除
     * 未删除
     */
    @TableField("DICT_DELETED_NAME")
    private String dictDeletedName;
}
