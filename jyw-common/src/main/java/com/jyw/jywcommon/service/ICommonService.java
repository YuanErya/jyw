package com.jyw.jywcommon.service;

import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;

public interface ICommonService {
    //编写泛型方法
    ShowListVO<ShowSimpleVO> AllSearch(Integer page, Integer limit, String key);
    ShowListVO<ShowSimpleVO> ListCommon(Integer page, Integer limit, Type type);
    ShowListVO<ShowSimpleVO> ListCommon(Integer page, Integer limit, Type type, String key);
}
