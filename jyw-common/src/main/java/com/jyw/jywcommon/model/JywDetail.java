package com.jyw.jywcommon.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("BASE_BULLETIN_DETAIL")
@AllArgsConstructor
@NoArgsConstructor
public class JywDetail {
    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;
    /**
     * 具体内容
     */
    @TableField("CONTENT")
    private String content;
}
