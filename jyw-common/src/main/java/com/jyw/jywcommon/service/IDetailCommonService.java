package com.jyw.jywcommon.service;

import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.common.api.Type;
import com.jyw.jywcommon.model.vo.DetailCommonVO;

public interface IDetailCommonService {
    ApiResult<DetailCommonVO> DetailCommon(Integer id, Type type);
}
