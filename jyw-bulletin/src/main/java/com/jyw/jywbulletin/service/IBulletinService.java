package com.jyw.jywbulletin.service;

import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jyw.jywbulletin.model.Bulletin;

import java.util.HashMap;

public interface IBulletinService extends IService<Bulletin> {
    public ShowListVO<ShowSimpleVO> listBulletin(Integer page, Integer limit, Integer type);
    public ShowListVO<ShowSimpleVO> search(Integer page, Integer limit, String key);

}
