package com.jyw.jywhomepage.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("BASE_PREACH_MEETING")
@AllArgsConstructor
@NoArgsConstructor
public class JywPreachMeeting {
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
     * 企业ID
     */
    @TableField("ENTERPRISE_ID")
    private Long enterpriseId;
    /**
     * 企业名
     */
    @TableField("ENTERPRISE_NAME")
    private String enterpriseName;
    /**
     * 老师ID
     */
    @TableField("TEACHER_ID")
    private Long teacherId;
    /**
     * 老师名称
     */
    @TableField("TEACHER_NAME")
    private String teacherName;
    /**
     * 发布时间点
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "PUBLISH_TIME", fill = FieldFill.INSERT)
    private Date publishTime;

    /**
     * 开始的时间点
     */
    @JSONField(format="HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    @TableField(value = "HOLD_START_TIME", fill = FieldFill.INSERT)
    private Date holdStartTime;

    /**
     * 结束的时间点
     */
    @JSONField(format="HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    @TableField(value = "HOLD_END_TIME", fill = FieldFill.INSERT)
    private Date holdEndTime;
    /**
     * 举办地点ID
     */
    @TableField("HOLD_PLACE_ID")
    private Long holdPlaceId;

    /**
     * 举办地点
     */
    @TableField("HOLD_PLACE_NAME")
    private String holdPlaceName;
    /**
     * 笔试场地ID
     */
    @TableField("WRITTEN_PLACE_ID")
    private Long writtenPlaceId;
    /**
     * 笔试场地名称
     */
    @TableField("WRITTEN_PLACE_NAME")
    private String writtenPlaceName;
    /**
     * 笔试场地规模
     */
    @TableField("DICT_WRITTEN_VENUE_SCALE_NAME")
    private String dictWrittenVenueScaleName;

    /**
     * 面试场地ID
     */
    @TableField("INTERVIEW_PLACE_ID")
    private Long interviewPlaceId;
    /**
     * 面试场地名称
     */
    @TableField("INTERVIEW_PLACE_NAME")
    private String interviewPlaceName;
    /**
     * 面试场地规模
     */
    @TableField("DICT_INTERVIEW_VENUE_SCALE_NAME")
    private String dictInterviewVenueScaleName;


    /**
     * 是否专场招聘
     */
    @TableField("DICT_GROUP_RECRUIT_NAME")
    private String dictGroupRecruitName;

    /**
     * 是否删除
     * 删除
     * 未删除
     */
    @TableField("DICT_DELETED_NAME")
    private String dictDeletedName;

    /**
     * 浏览量
     */
    @TableField("BROWSE_NUMBER")
    private Long browseNumber;
}
