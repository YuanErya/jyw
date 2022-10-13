package com.jyw.jywhomepage.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("BASE_ENTERPRISE")
@AllArgsConstructor
@NoArgsConstructor
public class JywEnterprise {
    /**
     * 主键id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    /**
     * 企业名
     */
    @TableField("NAME")
    private String name;

    /**
     * 企业性质
     */
    @TableField("DICT_NATURE_NAME")
    private String dictNatureName;

    /**
     * 企业规模
     */
    @TableField("DICT_SCALE_NAME")
    private String dictScaleName;

    /**
     * 所属行业
     */
    @TableField("DICT_INDUSTRY_NAME")
    private String dictIndustryName;

    /**
     * 企业标签
     */
    @TableField("DICT_GLOBAL500_NAME")
    private String dictGlobal500Name;

    /**
     * 企业隶属
     */
    @TableField("DICT_BELONG_NAME")
    private String dictBelongName;

    /**
     * 企业地址
     */
    @TableField("ADDRESS")
    private String address;

    /**
     * 企业邮编
     */
    @TableField("POSTCODE")
    private String postcode;

    /**
     * 企业微信公众号
     */
    @TableField("WECHAT_OFFICIAL_ACCOUNT")
    private String wechatOfficialAccount;

    /**
     * 企业官网
     */
    @TableField("WEBSITE")
    private String website;

    /**
     * 企业简介
     */
    @TableField("INTRODUCTION")
    private String introduction;

    /**
     * 单位所在地
     */
    @TableField("DICT_LOCATION_NAME")
    private String dictLocationName;



    /**
     * 企业是否通过审核，返回值有
     * 审核通过
     * 审核不通过
     *未审核
     *
     */
    @TableField("DICT_CHECK_STATE_NAME")
    private String dictCheckStateName;
}
