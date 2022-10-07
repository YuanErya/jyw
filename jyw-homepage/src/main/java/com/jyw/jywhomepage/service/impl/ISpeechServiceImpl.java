package com.jyw.jywhomepage.service.impl;

import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyw.jywhomepage.mapper.SpeechMapper;
import com.jyw.jywhomepage.model.Speech;
import com.jyw.jywhomepage.model.vo.SpeechVO;
import com.jyw.jywhomepage.service.ISpeechService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ISpeechServiceImpl extends ServiceImpl<SpeechMapper, Speech> implements ISpeechService {
    @Autowired
    private SpeechMapper speechMapper;

    /**
     *
     * @param page
     * @param limit
     * @param type
     * @return
     */
    @Override
    public ShowListVO<SpeechVO> listSpeech(Integer page, Integer limit, Integer type) {
        ShowListVO<SpeechVO> show = new ShowListVO<SpeechVO>();
        Page<Speech> plist = new Page<Speech>(page, limit);
        speechMapper.selectPage(plist, null);
        show.setType(Type.homepage_speech.getMessage());
        show.setTotalCount(plist.getTotal());
        show.setPageSize(plist.getSize());
        show.setTotalPage(plist.getPages());
        show.setCurrPage(plist.getCurrent());
        List<SpeechVO> list = new ArrayList<SpeechVO>();
        //简化为分页展示的格式，及省去了具体内容
        for (int i = 0; i < plist.getRecords().size(); i++) {
            SpeechVO vo = new SpeechVO();
            vo.setId(plist.getRecords().get(i).getId());
            vo.setType(plist.getRecords().get(i).getType().equals(Type.homepage_speech_preach.getCode())?
                    Type.homepage_speech_preach:Type.homepage_speech_double_choose);
            vo.setAddress(plist.getRecords().get(i).getAddress());

            //计算时间的天数差，要忽略具体时间点的影响
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
            long interval=0;
            try {
                interval = (formatter.parse(formatter.format(plist.getRecords().get(i).getStartDate().getTime())).getTime()
                        - formatter.parse(formatter.format(System.currentTimeMillis())).getTime()) / 1000 / 24 / 60 / 60;
            }catch(Exception e){
                log.error("时间格式错误");
            }
            if (interval >= 0 && interval < 10) {
                vo.setInterval(interval);
            } else {
                vo.setInterval(null);
            }
            vo.setTitle(plist.getRecords().get(i).getTitle());
            vo.setStartDate(plist.getRecords().get(i).getStartDate());
            vo.setStartTime(plist.getRecords().get(i).getStartTime());
            vo.setEndTime(plist.getRecords().get(i).getEndTime());
            list.add(vo);
        }
        show.setList(list);
        return show;
    }

    @Override
    public ShowListVO<SpeechVO> listCalendarSpeech(Integer page, Integer limit, Integer type, Long interval) {
        ShowListVO<SpeechVO> show = new ShowListVO<SpeechVO>();
        Page<Speech> plist = new Page<Speech>(page, limit);
        speechMapper.selectPage(plist, null);
        show.setType(Type.homepage_speech.getMessage());
        show.setPageSize(plist.getSize());
        show.setCurrPage(plist.getCurrent());
        List<SpeechVO> list = new ArrayList<SpeechVO>();
        //将简化为分页展示的格式，及省去了具体内容
        for (int i = 0; i < plist.getRecords().size(); i++) {
            SpeechVO vo = new SpeechVO();
            vo.setId(plist.getRecords().get(i).getId());
            vo.setType(plist.getRecords().get(i).getType().equals(Type.homepage_speech_preach.getCode())?
                    Type.homepage_speech_preach:Type.homepage_speech_double_choose);
            vo.setAddress(plist.getRecords().get(i).getAddress());
            //先洗去时间的具体时间点
            SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
            long tmpInterval=0;
            try {
                tmpInterval = (formatter.parse(formatter.format(plist.getRecords().get(i).getStartDate().getTime())).getTime()
                        - formatter.parse(formatter.format(System.currentTimeMillis())).getTime()) / 1000 / 24 / 60 / 60;
            }catch(Exception e){
                log.error("时间格式错误");
            }
            vo.setInterval(tmpInterval);
            vo.setTitle(plist.getRecords().get(i).getTitle());
            vo.setStartDate(plist.getRecords().get(i).getStartDate());
            vo.setStartTime(plist.getRecords().get(i).getStartTime());
            vo.setEndTime(plist.getRecords().get(i).getEndTime());
            if(tmpInterval==interval){list.add(vo);}
        }
        show.setTotalCount((long)list.size());
        show.setTotalPage((long)(list.size()/limit+1));
        show.setList(list);
        return show;
    }
}
