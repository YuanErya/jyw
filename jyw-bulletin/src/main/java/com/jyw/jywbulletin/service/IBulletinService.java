package com.jyw.jywbulletin.service;

import cn.jyw.feign.model.vo.ShowListVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jyw.jywbulletin.model.Bulletin;

import java.util.HashMap;

public interface IBulletinService extends IService<Bulletin> {
    public ShowListVO<Bulletin> listBulletin(Integer page, Integer limit, Integer type);
}
