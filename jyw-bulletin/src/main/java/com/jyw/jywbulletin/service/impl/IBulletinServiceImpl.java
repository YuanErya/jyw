package com.jyw.jywbulletin.service.impl;

import cn.hutool.json.JSONUtil;
import cn.jyw.feign.model.vo.ShowListVO;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyw.jywbulletin.mapper.BulletinMapper;
import com.jyw.jywbulletin.model.Bulletin;
import com.jyw.jywbulletin.service.IBulletinService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class IBulletinServiceImpl extends ServiceImpl<BulletinMapper,Bulletin> implements IBulletinService {

    @Autowired
    private BulletinMapper bulletinMapper;

    /**
     * 分页展示公告
     * @param page
     * @param limit
     * @param type
     * @return
     */
    public ShowListVO<Bulletin> listBulletin(Integer page, Integer limit, Integer type) {
        ShowListVO<Bulletin> show=new ShowListVO<Bulletin>();
        LambdaQueryWrapper<Bulletin> lqw=new LambdaQueryWrapper<>();
        lqw.eq(Bulletin::getType,type);
        Page<Bulletin> plist=new Page<Bulletin>(page,limit);
        bulletinMapper.selectPage(plist,lqw);
        show.setType(type==0?"通知公告":"政策法规");
        show.setTotalCount(plist.getTotal());
        show.setPageSize(plist.getSize());
        show.setTotalPage(plist.getPages());
        show.setCurrPage(plist.getCurrent());
        show.setList(plist.getRecords());
        return show;
    }
}
