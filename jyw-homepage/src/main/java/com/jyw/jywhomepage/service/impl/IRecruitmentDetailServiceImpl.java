package com.jyw.jywhomepage.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.jyw.jywhomepage.mapper.JywEnterpriseMapper;
import com.jyw.jywhomepage.mapper.JywRecruitmentDetailMapper;
import com.jyw.jywhomepage.mapper.JywRecruitmentMapper;
import com.jyw.jywhomepage.model.JywRecruitment;
import com.jyw.jywhomepage.model.JywRecruitmentDetail;
import com.jyw.jywhomepage.model.vo.RecruitmentDetailVO;
import com.jyw.jywhomepage.service.IRecruitmentDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class IRecruitmentDetailServiceImpl implements IRecruitmentDetailService {
    @Autowired
    private JywRecruitmentMapper jywRecruitmentMapper;
    @Autowired
    private JywRecruitmentDetailMapper jywRecruitmentDetailMapper;
    @Autowired
    private JywEnterpriseMapper jywEnterpriseMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public ApiResult<RecruitmentDetailVO> GetRecruitmentDetail(Integer id) {
        String recruitmentDetailVO = stringRedisTemplate.opsForValue().get("cache:Homepage:recruitment:detail:"+id);
        if (StrUtil.isNotBlank(recruitmentDetailVO)) {
            RecruitmentDetailVO cache=JSON.parseObject(recruitmentDetailVO, RecruitmentDetailVO.class);
            return ApiResult.success(cache);
        }
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
        stringRedisTemplate.opsForValue().set("cache:Homepage:recruitment:detail:"+id, JSON.toJSONString(vo),30, TimeUnit.MINUTES);
        return ApiResult.success(vo);
    }
}
