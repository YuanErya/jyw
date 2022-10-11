package com.jyw.jywhomepage.service;

import cn.jyw.feign.model.vo.ShowListVO;

import com.jyw.jywhomepage.model.vo.SpeechVO;

public interface IPreachMeetingService {
    ShowListVO<SpeechVO> listSpeech(Integer page, Integer limit, Integer type);

    ShowListVO<SpeechVO> listCalendarSpeech(Integer page, Integer limit, Integer type,Long interval);
}
