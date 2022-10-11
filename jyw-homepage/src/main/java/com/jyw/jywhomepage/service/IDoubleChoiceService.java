package com.jyw.jywhomepage.service;

import cn.jyw.feign.model.vo.ShowListVO;
import com.jyw.jywhomepage.model.vo.SpeechVO;

public interface IDoubleChoiceService {
    ShowListVO<SpeechVO> listSpeech(Integer page, Integer limit, Integer type);

}
