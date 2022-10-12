package com.jyw.jywhomepage.service.impl;

import cn.jyw.feign.common.api.ApiResult;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jyw.jywhomepage.mapper.JywEnterpriseMapper;
import com.jyw.jywhomepage.mapper.JywRecruitmentDetailMapper;
import com.jyw.jywhomepage.mapper.JywRecruitmentMapper;
import com.jyw.jywhomepage.model.JywRecruitment;
import com.jyw.jywhomepage.model.JywRecruitmentDetail;
import com.jyw.jywhomepage.model.vo.RecruitmentDetailVO;
import com.jyw.jywhomepage.service.IRecruitmentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRecruitmentDetailServiceImpl implements IRecruitmentDetailService {
    @Autowired
    private JywRecruitmentMapper jywRecruitmentMapper;
    @Autowired
    private JywRecruitmentDetailMapper jywRecruitmentDetailMapper;
    @Autowired
    private JywEnterpriseMapper jywEnterpriseMapper;

    @Override
    public ApiResult<RecruitmentDetailVO> GetRecruitmentDetail(Integer id) {
        JywRecruitment jywRecruitment=jywRecruitmentMapper.selectOne(
                new LambdaQueryWrapper<JywRecruitment>()
                        .eq(JywRecruitment::getId,id)
                        .eq(JywRecruitment::getDictDeletedName,"未删除"));
        if(jywRecruitment==null){
            return ApiResult.failed("暂无该id数据的");
        }
        RecruitmentDetailVO vo=RecruitmentDetailVO.builder()
                .id(id)
                .title(jywRecruitment.getTitle())
                .enterpriseId(jywRecruitment.getEnterpriseId())
                .enterpriseName(jywRecruitment.getEnterpriseName())
                .publishTime(jywRecruitment.getPublishTime())
                .recruitmentType(jywRecruitment.getDictRecruitmentTypeName())
                .tags(jywRecruitment.getTags())
                .resumeDeliveryStartTime(jywRecruitment.getResumeDeliveryStartTime())
                .resumeDeliveryEndTime(jywRecruitment.getResumeDeliveryEndTime())
                .resumeDeliveryEmail(jywRecruitment.getResumeDeliveryEmail())
                .workplace(jywRecruitment.getWorkplace())
                .dictResumeReceiveName(jywRecruitment.getDictResumeReceiveName())
                .onlineApplication(jywRecruitment.getOnlineApplication())
                .viewCount(jywRecruitment.getBrowseNumber())
                .content(jywRecruitmentDetailMapper.selectOne(
                        new LambdaQueryWrapper<JywRecruitmentDetail>()
                                .eq(JywRecruitmentDetail::getBaseRecruitmentId,id)).getContent())
                .enterprise(jywEnterpriseMapper.selectById(jywRecruitment.getEnterpriseId()))
                .build();
        return ApiResult.success(vo);
    }
}
