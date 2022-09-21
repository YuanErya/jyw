package cn.jyw.feign.model.vo;


import cn.jyw.feign.common.api.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
//该类用于简化数据，分页查询展示的时候省略了内容
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShowSimpleVO {
    private Integer id;
    private Type type;
    private String title;
    @JsonFormat(pattern = "yyyy/MM/dd")
    private Date createTime;
}
