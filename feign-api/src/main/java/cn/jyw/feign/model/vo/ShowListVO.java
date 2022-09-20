package cn.jyw.feign.model.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShowListVO<T> {
    private String type;
    private Long totalCount;
    private Long pageSize;
    private Long totalPage;
    private Long currPage;
    private List<T> list;
}
