package com.jyw.jywcommon.service;

import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;

public interface ICommonService {
    public ShowListVO<ShowSimpleVO> ListCommon(Integer page, Integer limit, Type type);
    public ShowListVO<ShowSimpleVO> ListCommon(Integer page, Integer limit,Type type,String key);
}
