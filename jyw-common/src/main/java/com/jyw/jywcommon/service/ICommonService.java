package com.jyw.jywcommon.service;

import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.jyw.jywcommon.model.Common;

public interface ICommonService {
    //编写泛型方法
    ShowListVO<ShowSimpleVO> ListCommon(Integer page, Integer limit, Type type);
    <T extends Common>ShowListVO<ShowSimpleVO> ListCommon(T t,Integer page, Integer limit, Type type, String key);
}
