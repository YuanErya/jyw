package com.jyw.jywhomepage.model.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//该类用于格式化双选会
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DoubleChoiceDetailVO {
    /**
     * 主键ID
     */
    Integer id;
    /**
     * 年份
     */
    String year;
    /**
     * 标题
     */
    String title;
    /**
     * 发布时间点
     */
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    Date publishTime;
    /**
     * 开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date startDate;
    /**
     * 开始时间点
     */
    @JsonFormat(pattern = "HH:mm:ss")
    Date startTime;
    /**
     * 结束时间点
     */
    @JsonFormat(pattern = "HH:mm:ss")
    Date endTime;

    /**
     * 开始报名的时间点
     */
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    Date applyStartTime;

    /**
     * 报名结束的时间点
     */
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    Date applyEndTime;

    /**
     * 展位图url
     */
    private String boothImgUrl;

    /**
     * 浏览量
     */
    private  Long viewCount;

    /**
     * 内容
     */
    private String content;
}
