package cn.jyw.feign.common.api;

import cn.jyw.feign.common.config.BaseEnumSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = BaseEnumSerializer.class)
public interface ITypeCode {
    /**
     * 类型编码
     *
     * @return 类型编码
     */
    Integer getCode();

    /**
     * 类型描述
     *
     * @return 类型描述
     */
    String getMessage();
}
