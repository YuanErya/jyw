package com.jyw.jywdouble.service;

import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jyw.jywdouble.model.Bulletin;

public interface IBulletinService extends IService<Bulletin> {
    ShowListVO<ShowSimpleVO> listBulletin(Integer page, Integer limit, Integer type);

    ShowListVO<ShowSimpleVO> search(Integer page, Integer limit, String key);
}
