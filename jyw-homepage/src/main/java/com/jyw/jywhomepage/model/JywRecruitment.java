package com.jyw.jywhomepage.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("JYW_RECRUITMENT")
@AllArgsConstructor
@NoArgsConstructor
public class JywRecruitment {
    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
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

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "APPLY_TIME", fill = FieldFill.INSERT)
    private Date applyTime;

    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "AUDIT_TIME", fill = FieldFill.INSERT)
    private Date auditTime;

    /**
     * 招聘类型的代码
     * 5020050000000001实习
     * 5020050000000002招聘
     */
    @TableField("DICT_RECRUITMENT_TYPE_VALUE")
    private Long dictRecruitmentTypeValue;

    /**
     * 标题
     */
    @TableField("TITLE")
    private String title;

    /**
     * 审核是否通过
     * 结果有：
     * 未提交
     * 通过
     * 退回
     */
    @TableField("FLOW_STATUS")
    private String flowStatus;


}
