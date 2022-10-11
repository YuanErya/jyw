package com.jyw.jywhomepage.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("FLOW_PREACH_MEETING")
@AllArgsConstructor
@NoArgsConstructor
public class JywPreachMeeting {
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
     * 地址
     */
    @TableField("HOLD_PLACE_NAME")
    private String holderPlaceName;

    /**
     * 开始的时间点
     */
    @JSONField(format="HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    @TableField(value = "HOLD_START_TIME", fill = FieldFill.INSERT)
    private Date holderStartTime;

    /**
     * 结束的时间点
     */
    @JSONField(format="HH:mm:ss")
    @JsonFormat(pattern = "HH:mm:ss")
    @TableField(value = "HOLD_END_TIME", fill = FieldFill.INSERT)
    private Date holdEndTime;

    /**
     * 审核是否通过，结果有
     * 通过
     * 就业中心待审核
     * 退回
     */
    @TableField("FLOW_STATUS")
    private String flowStatus;

}
