package com.jyw.jywdouble.model.vo;


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
public class DepartmentActivityVO {
    /**
     * 主键ID
     */
    private Integer id;
    /**
     * 标题
     */
    private String title;
    /**
     * 类型
     */
    private Type type;

    /**
     * 学院ID
     */
    private  Integer departmentId;

    /**
     * 学院名
     */
    private String departmentName;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date createTime;
}
