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

    /**
     * 根据真实ID返回Type
     *
     * @param
     * @return
     */
    public static Type GetType(Integer id) {
        switch (id) {
            case 40:
                //就业指南
                return Type.job_guide;
            case 10:
                //公告政策
                return Type.bulletin_announcement;
            case 20:
                //政策
                return Type.bulletin_policy;
            case 100:
                //职场活动
                return Type.workplace_activity;
            case 90:
                //新闻动态
                return Type.news_trends;
            case 60:
                //知名企业
                return Type.well_known_enterprises;
            case 110:
                //校招指南
                return Type.school_recruitment_guide;
        }
        return null;
    }


}
