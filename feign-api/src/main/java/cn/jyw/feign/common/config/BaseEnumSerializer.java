package cn.jyw.feign.common.config;

import cn.jyw.feign.common.api.ITypeCode;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseEnumSerializer extends JsonSerializer {
    @Override
    public void serialize(Object value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        ITypeCode mapEnum = (ITypeCode) value;

        Map<String,Object> map = new HashMap<>();
        map.put("typeCode", mapEnum.getCode());
        map.put("typeName", mapEnum.getMessage());
        gen.writeObject(map);
    }
}
