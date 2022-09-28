package com.jyw.jywhomepage.model.vo;

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
public class SpeechVO {
    private Integer id;
    private Type type;
    private String title;
    private String address;
    private Long interval;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date startDate;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date startTime;
    @JsonFormat(pattern = "HH:mm:ss")
    private Date endTime;
}
