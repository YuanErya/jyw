package com.jyw.jywdouble.controller;


import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.model.vo.ShowListVO;
import cn.jyw.feign.model.vo.ShowSimpleVO;
import com.jyw.jywdouble.model.Bulletin;
import com.jyw.jywdouble.service.IBulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/jyw/double")
public class DoubleController {
    @Autowired
    private IBulletinService iBulletinService;

    /**
     * @param page  查询的页码
     * @param limit 每页的条数
     * @param type  类型 该项为必传参数
     * @return
     */
    @GetMapping("bulletin/list")
    public ApiResult<ShowListVO<ShowSimpleVO>> ShowList(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                        @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                        @RequestParam(value = "type", required = true) Integer type) {
        if (type != 3001 && type != 3002) {
            return ApiResult.failed("请校验类型参数");
        }
        return ApiResult.success(iBulletinService.listBulletin(page, limit, type));
    }

    /**
     * 关键字搜索
     *
     * @param page
     * @param limit
     * @param key   关键字
     * @return
     */
    @GetMapping("/bulletin/search")
    public ApiResult<ShowListVO<ShowSimpleVO>> Search(@RequestParam(value = "page", defaultValue = "1") Integer page,
                                                      @RequestParam(value = "limit", defaultValue = "6") Integer limit,
                                                      @RequestParam(value = "key", required = true) String key) {
        return ApiResult.success(iBulletinService.search(page, limit, key));
    }

    /**
     * 根据id获取到详情页所需要的内容
     *
     * @param id
     * @return
     */
    @GetMapping("/bulletin/detail")
    public ApiResult<Bulletin> GetById(@RequestParam(value = "id", required = true) Integer id) {

        Bulletin bulletin = iBulletinService.getById(id);
        if (bulletin == null) {
            return ApiResult.failed("暂无此id数据");
        }
        return ApiResult.success(bulletin);
    }


}
