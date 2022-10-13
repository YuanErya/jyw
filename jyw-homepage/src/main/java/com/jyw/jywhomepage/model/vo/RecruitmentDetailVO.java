package com.jyw.jywhomepage.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jyw.jywhomepage.model.JywEnterprise;
import com.jyw.jywhomepage.model.JywRecruitment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecruitmentDetailVO {
    /**
     * 主键id
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 雇主id
     */
    private Integer enterpriseId;
    /**
     * 雇主名称
     */
    private String enterpriseName;

    /**
     * 发布时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date publishTime;

    /**
     * 招聘类型
     * 招聘
     * 实习
     */
    private String recruitmentType;

    /**
     * 标签
     */
    private String tags;

    /**
     * 简历投递开始时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date resumeDeliveryStartTime;

    /**
     * 简历投递结束时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date resumeDeliveryEndTime;
    /**
     * 简历接收邮箱
     */
    private String resumeDeliveryEmail;

    /**
     * 工作地点
     */
    private String workplace;

    /**
     * 简历 接收方式
     */
    private String dictResumeReceiveName;

    /**
     * 网申地址
     */
    private String onlineApplication;

    /**
     * 访问量
     */
    private Long viewCount;
    /**
     * 内容
     */
    private String content;
    /**
     * 返回企业
     */
    private JywEnterprise enterprise;
}
