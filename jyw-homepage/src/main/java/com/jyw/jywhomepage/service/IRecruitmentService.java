package com.jyw.jywhomepage.service;

import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jyw.jywhomepage.model.Recruitment;

public interface IRecruitmentService extends IService<Recruitment> {
    ShowListVO<ShowSimpleVO> listRecruitment(Integer page, Integer limit, Integer type);
}
