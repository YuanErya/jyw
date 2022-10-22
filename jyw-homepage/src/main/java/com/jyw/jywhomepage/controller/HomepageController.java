package com.jyw.jywhomepage.controller;

import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.jyw.jywhomepage.model.vo.SpeechVO;
import com.jyw.jywhomepage.service.IDoubleChoiceService;
import com.jyw.jywhomepage.service.IRecruitmentService;
import com.jyw.jywhomepage.service.IPreachMeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jyw/homepage")
public class HomepageController {
    @Autowired
    private IRecruitmentService iRecruitmentService;
    @Autowired
    private IPreachMeetingService iPreachMeetingService;
    @Autowired
    private IDoubleChoiceService iDoubleChoiceService;

    /**
     * 首页的分页展示
     *
     * @param page
     * @param limit
     * @param type
     * @return
     */
    @GetMapping("/recruitment/list")
    public ApiResult<ShowListVO<ShowSimpleVO>> ShowRecruitmentList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                   @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                                   @RequestParam(value = "type", required = true) Integer type) {
        if (type != 1001 && type != 1003) {
            return ApiResult.failed("请校验类型参数");
        }
        return ApiResult.success(iRecruitmentService.listRecruitment(page, limit, type));
    }




    /**
     * 首页的宣讲会的分页展示
     *
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/speech/list")
    public ApiResult<ShowListVO<SpeechVO>> ShowSpeechList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                          @RequestParam(value = "limit", defaultValue = "6") Integer limit
    ) {
        return ApiResult.success(iPreachMeetingService.listSpeech(page, limit, Type.homepage_speech.getCode()));
    }

    /**
     * 首页的宣讲会的日历查询
     * @param page
     * @param limit
     * @param interval
     * @return
     */
    @GetMapping("/speech/calendar")
    public ApiResult<ShowListVO<SpeechVO>> CalendarSpeech(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                          @RequestParam(value = "limit", defaultValue = "100") Integer limit,
                                                          @RequestParam(value = "interval", defaultValue = "0") Long interval) {

        return ApiResult.success(iPreachMeetingService.listCalendarSpeech(page, limit, Type.homepage_speech.getCode(), interval));
    }

    /**
     * 双选会的分页展示
     * @param page
     * @param limit
     * @return
     */
    @GetMapping("/doubleChoice/list")
    public ApiResult<ShowListVO<SpeechVO>> ShowDoubleChoiceList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                                @RequestParam(value = "limit", defaultValue = "6") Integer limit) {
        return ApiResult.success(iDoubleChoiceService.listSpeech(page, limit, Type.homepage_speech_double_choose.getCode()));
    }


}
