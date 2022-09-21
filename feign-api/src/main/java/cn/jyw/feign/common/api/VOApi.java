package cn.jyw.feign.common.api;

import cn.jyw.feign.model.vo.ShowSimpleVO;

public class VOApi {
    public static ShowSimpleVO ToShowSimpleVO(Object obj,String type){
        if(obj instanceof ShowSimpleVO){}
        return null;
    }
}
