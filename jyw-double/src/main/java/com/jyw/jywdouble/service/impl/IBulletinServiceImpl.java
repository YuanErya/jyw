package com.jyw.jywdouble.service.impl;


import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyw.jywdouble.mapper.BulletinMapper;
import com.jyw.jywdouble.mapper.JywBulletinMapper;
import com.jyw.jywdouble.model.Bulletin;
import com.jyw.jywdouble.model.JywBulletin;
import com.jyw.jywdouble.service.IBulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IBulletinServiceImpl extends ServiceImpl<BulletinMapper, Bulletin> implements IBulletinService {

    @Autowired
    private BulletinMapper bulletinMapper;
    @Autowired
    private JywBulletinMapper jywBulletinMapper;

    /**
     * 分页展示公告
     *
     * @param page
     * @param limit
     * @param type
     * @return
     */
    public ShowListVO<ShowSimpleVO> listBulletin(Integer page, Integer limit, Integer type) {
        ShowListVO<ShowSimpleVO> show = new ShowListVO<ShowSimpleVO>();
        LambdaQueryWrapper<JywBulletin> lqw = new LambdaQueryWrapper<>();
        //源数据库中id10为公告，20为政策
        lqw.eq(JywBulletin::getMenuId,type.equals(Type.bulletin_announcement.getCode())?10:20);
        lqw.orderByDesc(JywBulletin::getCreateTime);//按时间排序
        lqw.orderByAsc(JywBulletin::getId);//时间相同则按照id进行排序
        Page<JywBulletin> plist = new Page<JywBulletin>(page, limit);
        jywBulletinMapper.selectPage(plist, lqw);
        show.setType(type.equals(Type.bulletin_announcement.getCode())?
                Type.bulletin_announcement.getMessage():Type.bulletin_policy.getMessage());
        show.setTotalCount(plist.getTotal());
        show.setPageSize(plist.getSize());
        show.setTotalPage(plist.getPages());
        show.setCurrPage(plist.getCurrent());
        List<ShowSimpleVO> list = new ArrayList<ShowSimpleVO>();
        //将Bulltin简化为分页展示的格式，及省去了具体内容
        for (int i = 0; i < plist.getRecords().size(); i++) {
            ShowSimpleVO vo = new ShowSimpleVO();
            vo.setId(plist.getRecords().get(i).getId());
            vo.setType(type.equals(Type.bulletin_announcement.getCode())?Type.bulletin_announcement:Type.bulletin_policy);
            vo.setTitle(plist.getRecords().get(i).getTitle());
            vo.setCreateTime(plist.getRecords().get(i).getCreateTime());
            list.add(vo);
        }
        show.setList(list);
        return show;
    }

    /**
     * 关键字检索
     *
     * @param page  当前页数
     * @param limit 每页的 条数
     * @param key   关键字
     * @return
     */
    @Override
    public ShowListVO<ShowSimpleVO> search(Integer page, Integer limit, String key) {
        ShowListVO<ShowSimpleVO> show = new ShowListVO<ShowSimpleVO>();
        LambdaQueryWrapper<JywBulletin> lqw = new LambdaQueryWrapper<>();
        //根据KEY对标题和内容均进行匹配,10,20是公告和政策
        lqw.like(JywBulletin::getTitle, key)
                .eq(JywBulletin::getMenuId,10)
                .or().eq(JywBulletin::getMenuId,20);
        lqw.orderByDesc(JywBulletin::getCreateTime);//按时间排序
        lqw.orderByAsc(JywBulletin::getId);//时间相同则按照id进行排序
        Page<JywBulletin> plist = new Page<JywBulletin>(page, limit);
        jywBulletinMapper.selectPage(plist, lqw);
        show.setType(Type.bulletin_announcement.getMessage());
        show.setTotalCount(plist.getTotal());
        show.setPageSize(plist.getSize());
        show.setTotalPage(plist.getPages());
        show.setCurrPage(plist.getCurrent());
        List<ShowSimpleVO> list = new ArrayList<ShowSimpleVO>();
        //将Bulltin简化为分页展示的格式，及省去了具体内容
        for (int i = 0; i < plist.getRecords().size(); i++) {
            ShowSimpleVO vo = new ShowSimpleVO();
            vo.setId(plist.getRecords().get(i).getId());
            vo.setType(Type.bulletin_announcement);
            vo.setTitle(plist.getRecords().get(i).getTitle());
            vo.setCreateTime(plist.getRecords().get(i).getCreateTime());
            list.add(vo);
        }
        show.setList(list);
        return show;
    }
}
