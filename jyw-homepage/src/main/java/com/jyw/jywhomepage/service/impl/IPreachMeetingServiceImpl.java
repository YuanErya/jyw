package com.jyw.jywhomepage.service.impl;

import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jyw.jywhomepage.mapper.JywDoubleChoiceMapper;
import com.jyw.jywhomepage.mapper.JywPreachMeetingMapper;
import com.jyw.jywhomepage.model.JywPreachMeeting;
import com.jyw.jywhomepage.model.vo.SpeechVO;
import com.jyw.jywhomepage.service.IPreachMeetingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class IPreachMeetingServiceImpl implements IPreachMeetingService {
    @Autowired
    private JywPreachMeetingMapper jywPreachMeetingMapper;

     SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * @param page
     * @param limit
     * @param type
     * @return
     */
    @Override
    public ShowListVO<SpeechVO> listSpeech(Integer page, Integer limit, Integer type) {
        ShowListVO<SpeechVO> show = new ShowListVO<SpeechVO>();
        Page<JywPreachMeeting> plist = new Page<JywPreachMeeting>(page, limit);
        LambdaQueryWrapper<JywPreachMeeting> lqw = new LambdaQueryWrapper<>();
        lqw.eq(JywPreachMeeting::getDictDeletedName, "未删除");
        lqw.orderByDesc(JywPreachMeeting::getHoldStartTime);//按时间排序
        lqw.orderByAsc(JywPreachMeeting::getId);//时间相同则按照id进行排序
        jywPreachMeetingMapper.selectPage(plist, lqw);
        show.setType(Type.homepage_speech.getMessage());
        show.setTotalCount(plist.getTotal());
        show.setPageSize(plist.getSize());
        show.setTotalPage(plist.getPages());
        show.setCurrPage(plist.getCurrent());
        List<SpeechVO> list = new ArrayList<SpeechVO>();
        //简化为分页展示的格式，及省去了具体内容
        for (int i = 0; i < plist.getRecords().size(); i++) {
            SpeechVO vo = SpeechVO.builder()
                    .id(plist.getRecords().get(i).getId())
                    .type(Type.homepage_speech_preach)
                    .address(plist.getRecords().get(i).getHoldPlaceName())
                    .build();
            //计算时间的天数差，要忽略具体时间点的影响
            long interval = 0;
            try {
                interval = (formatter.parse(formatter.format(plist.getRecords().get(i).getHoldStartTime().getTime())).getTime()
                        - formatter.parse(formatter.format(System.currentTimeMillis())).getTime()) / 1000 / 24 / 60 / 60;
            } catch (Exception e) {
                log.error("时间格式错误");
            }
            if (interval >= 0 && interval < 10) {
                vo.setInterval(interval);
            } else {
                vo.setInterval(null);
            }
            vo.setTitle(plist.getRecords().get(i).getTitle());
            vo.setStartDate(plist.getRecords().get(i).getHoldStartTime());
            vo.setStartTime(plist.getRecords().get(i).getHoldStartTime());
            vo.setEndTime(plist.getRecords().get(i).getHoldEndTime());
            list.add(vo);
        }
        show.setList(list);
        return show;
    }

    @Override
    public ShowListVO<SpeechVO> listCalendarSpeech(Integer page, Integer limit, Integer type, Long interval) {
        ShowListVO<SpeechVO> show = new ShowListVO<SpeechVO>();
        Page<JywPreachMeeting> plist = new Page<JywPreachMeeting>(page, limit);
        LambdaQueryWrapper<JywPreachMeeting> lqw = new LambdaQueryWrapper<>();
        lqw.eq(JywPreachMeeting::getDictDeletedName, "未删除");
        lqw.orderByDesc(JywPreachMeeting::getHoldStartTime);//按时间排序
        lqw.orderByAsc(JywPreachMeeting::getId);//时间相同则按照id进行排序
        jywPreachMeetingMapper.selectPage(plist, lqw);
        show.setType(Type.homepage_speech.getMessage());
        show.setPageSize(plist.getSize());
        show.setCurrPage(plist.getCurrent());
        List<SpeechVO> list = new ArrayList<SpeechVO>();
        //将简化为分页展示的格式，及省去了具体内容
        for (int i = 0; i < plist.getRecords().size(); i++) {
            SpeechVO vo = SpeechVO.builder()
                    .id(plist.getRecords().get(i).getId())
                    .type(Type.homepage_speech_preach)
                    .address(plist.getRecords().get(i).getHoldPlaceName())
                    .build();
            long tmpInterval = 0;
            try {
                tmpInterval = (formatter.parse(formatter.format(plist.getRecords().get(i).getHoldStartTime().getTime())).getTime()
                        - formatter.parse(formatter.format(System.currentTimeMillis())).getTime()) / 1000 / 24 / 60 / 60;
            } catch (Exception e) {
                log.error("时间格式错误");
            }
            vo.setInterval(tmpInterval);
            vo.setTitle(plist.getRecords().get(i).getTitle());
            vo.setStartDate(plist.getRecords().get(i).getHoldStartTime());
            vo.setStartTime(plist.getRecords().get(i).getHoldStartTime());
            vo.setEndTime(plist.getRecords().get(i).getHoldEndTime());
            if (tmpInterval == interval) {
                list.add(vo);
            }
        }
        show.setTotalCount((long) list.size());
        show.setTotalPage((long) (list.size() / limit + 1));
        show.setList(list);
        return show;
    }
}
