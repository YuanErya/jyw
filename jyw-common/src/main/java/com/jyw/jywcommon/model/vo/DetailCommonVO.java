package com.jyw.jywcommon.model.vo;

import cn.jyw.feign.common.api.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetailCommonVO {
    private Integer id;
    private Type type;
    private String title;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date createTime;
    /**
     * 浏览量
     */
    private  Integer viewCount;
    /**
     * 具体内容
     */
    private String content;
    /**
     * 信息来源
     */
    private String source;
    /**
     * 附件
     */
    private String attachment;
}
