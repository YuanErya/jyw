package com.jyw.jywhomepage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("BASE_RECRUITMENT_BLOB")
@AllArgsConstructor
@NoArgsConstructor
public class JywRecruitmentDetail {
    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 招聘id或者实习ID
     */
    @TableField("BASE_RECRUITMENT_ID")
    private Long baseRecruitmentId;
    /**
     * 内容
     */
    @TableField("CONTENT")
    private String content;

}
