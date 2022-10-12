package com.jyw.jywhomepage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("BASE_DOUBLE_CHOICE_BLOB")
@AllArgsConstructor
@NoArgsConstructor
public class JywDoubleChoiceDetail {

    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 双选会id
     */
    @TableField("DOUBLE_CHOICE_ID")
    private Long doubleChoiceId;

    /**
     * 内容
     */
    @TableField("CONTENT")
    private String content;



}
