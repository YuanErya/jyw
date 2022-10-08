package com.jyw.jywcommon.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Common {
    private Integer id;
    private Integer type;
    private String title;
    private String content;
    private Date createTime;
}
