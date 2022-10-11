package com.jyw.jywcommon.api;

import cn.jyw.feign.common.api.Type;

public class API {

    /**
     * 返回查询时的真是原数据库表中的真实ID
     *
     * @param type
     * @return
     */
    public static Integer GetTrueType(Type type) {
        Integer trueType = 0;
        switch (type.getCode()) {
            case 2000:
                //就业指南
                trueType = 40;
                break;
            case 3000:
                //公告政策
                trueType = 10;
                break;
            case 3001:
                //公告
                trueType = 10;
                break;
            case 3002:
                //政策
                trueType = 20;
                break;
            case 4000:
                //职场活动
                trueType = 100;
                break;
            case 5000:
                //新闻动态
                trueType = 90;
                break;
            case 6000:
                //知名企业
                trueType = 60;
                break;
            case 7000:
                //校招指南
                trueType = 110;
                break;
        }
        return trueType;
    }
}
