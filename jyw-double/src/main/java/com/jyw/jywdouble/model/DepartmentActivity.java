package com.jyw.jywdouble.model;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@TableName("BASE_COLLEGE_INFO")
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentActivity {

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
     * 学院ID
     */
    @TableField("DICT_COLLEGE_ID")
    private  Integer dictCollegeId;

    /**
     * 学院名
     */
    @TableField("DICT_COLLEGE_NAME")
    private String dictCollegeName;

    /**
     * 浏览量
     */
    @TableField("VIEW_COUNT")
    private  Long viewCount;

    /**
     * 是否删除
     * 删除
     * 未删除
     */
    @TableField("DICT_DELETED_NAME")
    private String dictDeletedName;

    /**
     * 创建时间
     */
    @JSONField(format="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @TableField(value = "CREATE_TIME", fill = FieldFill.INSERT)
    private Date createTime;
}
