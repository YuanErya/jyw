package com.jyw.jywcommon.service.impl;

import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.common.api.Type;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jyw.jywcommon.api.API;
import com.jyw.jywcommon.mapper.JywBulletinMapper;
import com.jyw.jywcommon.mapper.JywDetailMapper;
import com.jyw.jywcommon.model.JywBulletin;
import com.jyw.jywcommon.model.vo.DetailCommonVO;
import com.jyw.jywcommon.service.IDetailCommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IDetailCommonServiceImpl implements IDetailCommonService {
    @Autowired
    private JywBulletinMapper jywBulletinMapper;
    @Autowired
    private JywDetailMapper jywDetailMapper;
    @Override
    public ApiResult<DetailCommonVO> DetailCommon(Integer id, Type type) {

        JywBulletin jywcommon=jywBulletinMapper.selectOne(new LambdaQueryWrapper<JywBulletin>()
                .eq(JywBulletin::getId,id)
        .eq(JywBulletin::getMenuId,API.GetTrueType(type)));
        if(jywcommon==null){
            return ApiResult.failed("暂无该id数据的"+type.getMessage());
        }
        DetailCommonVO vo = DetailCommonVO.builder()
                .id(id)
                .type(type)
                .title(jywcommon.getTitle())
                .createTime(jywcommon.getCreateTime())
                .viewCount(jywcommon.getViewCount())
                .content(jywDetailMapper.selectById(id).getContent())
                .source(jywcommon.getSource())
                .attachment(jywcommon.getAttachment())
                .build();
        return ApiResult.success(vo);
    }
}
