package com.jyw.jywbulletin.controller;


import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.model.vo.ShowListVO;
import com.jyw.jywbulletin.model.Bulletin;
import com.jyw.jywbulletin.service.IBulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/jyw/bulletin")
public class BulletinController {
    @Autowired
    private IBulletinService iBulletinService;

    /**
     *
     * @param page 查询的页码
     * @param limit 每页的条数
     * @param type 类型 该项为必传参数
     * @return
     */
    @GetMapping("/list")
    public ApiResult<ShowListVO<Bulletin>>  showList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                     @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                     @RequestParam(value = "type",required =true) Integer type){
        if(type!=0&&type!=1){
            return ApiResult.failed("请校验类型参数");
        }
        return ApiResult.success(iBulletinService.listBulletin(page, limit, type));
    }


}
