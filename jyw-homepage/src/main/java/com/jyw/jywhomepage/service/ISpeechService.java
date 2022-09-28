package com.jyw.jywhomepage.service;

import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jyw.jywhomepage.model.Speech;
import com.jyw.jywhomepage.model.vo.SpeechVO;

public interface ISpeechService extends IService<Speech> {
    ShowListVO<SpeechVO> listSpeech(Integer page, Integer limit, Integer type);

    ShowListVO<SpeechVO> listCalendarSpeech(Integer page, Integer limit, Integer type,Long interval);
}
