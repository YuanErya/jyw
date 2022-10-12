package com.jyw.jywhomepage.service;

import cn.jyw.feign.common.api.ApiResult;
import com.jyw.jywhomepage.model.vo.RecruitmentDetailVO;

public interface IRecruitmentDetailService {
    ApiResult<RecruitmentDetailVO> GetRecruitmentDetail(Integer id);
}
