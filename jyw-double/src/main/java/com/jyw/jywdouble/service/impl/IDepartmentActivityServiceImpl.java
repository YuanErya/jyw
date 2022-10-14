package com.jyw.jywdouble.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.jyw.feign.common.api.ApiResult;
import cn.jyw.feign.common.api.Type;
import cn.jyw.feign.model.vo.ShowListVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jyw.jywdouble.mapper.DepartmentActivityDetailMapper;
import com.jyw.jywdouble.mapper.DepartmentActivityMapper;
import com.jyw.jywdouble.model.DepartmentActivity;
import com.jyw.jywdouble.model.DepartmentActivityDetail;
import com.jyw.jywdouble.model.vo.DepartmentActivityDetailVO;
import com.jyw.jywdouble.model.vo.DepartmentActivityVO;
import com.jyw.jywdouble.service.IDepartmentActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

@Service
public class IDepartmentActivityServiceImpl implements IDepartmentActivityService {
    @Autowired
    private DepartmentActivityMapper departmentActivityMapper;
    @Autowired
    private DepartmentActivityDetailMapper departmentActivityDetailMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 列表展示
     * @param page
     * @param limit
     * @param type
     * @param departmentId
     * @return
     */
    @Override
    public ShowListVO<DepartmentActivityVO> ListDepartmentActivity(Integer page, Integer limit, Type type,Integer departmentId) {
        String showDepartmentActivityVO = stringRedisTemplate.opsForValue().get("cache:Double:departmentActivityList:"+page+","+limit);
        if (StrUtil.isNotBlank(showDepartmentActivityVO)) {
            return  JSON.parseObject(showDepartmentActivityVO, new TypeReference<ShowListVO<DepartmentActivityVO>>(){});
        }
        ShowListVO<DepartmentActivityVO> show = new ShowListVO<DepartmentActivityVO>();
        Page<DepartmentActivity> List = new Page<DepartmentActivity>(page, limit);
        LambdaQueryWrapper<DepartmentActivity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(DepartmentActivity::getDictCollegeId,departmentId)
                .eq(DepartmentActivity::getDictDeletedName, "未删除");//筛选学院
        lqw.orderByDesc(DepartmentActivity::getCreateTime);//按时间排序
        lqw.orderByAsc(DepartmentActivity::getId);//时间相同则按照id进行排序
        departmentActivityMapper.selectPage(List, lqw);
        GetShowList(List, type, show);
        //两个小时过期
        stringRedisTemplate.opsForValue().set("cache:Double:departmentActivityList:"+page+","+limit, JSON.toJSONString(show),2, TimeUnit.HOURS);
        return show;
    }

    /**
     * 检索
     * @param page
     * @param limit
     * @param type
     * @param key
     * @return
     */
    @Override
    public ShowListVO<DepartmentActivityVO> ListDepartmentActivity(Integer page, Integer limit, Type type, String key) {
        String showDepartmentActivityVO = stringRedisTemplate.opsForValue().get("cache:Double:departmentActivityList:search:"+page+","+limit+","+key);
        if (StrUtil.isNotBlank(showDepartmentActivityVO)) {
            return JSON.parseObject(showDepartmentActivityVO, new TypeReference<ShowListVO<DepartmentActivityVO>>(){});
        }
        ShowListVO<DepartmentActivityVO> show = new ShowListVO<>();
        Page<DepartmentActivity> List = new Page<DepartmentActivity>(page, limit);
        LambdaQueryWrapper<DepartmentActivity> lqw = new LambdaQueryWrapper<>();
        lqw.eq(DepartmentActivity::getDictDeletedName, "未删除");
        lqw.like(DepartmentActivity::getTitle, key);
        lqw.orderByDesc(DepartmentActivity::getCreateTime);//按时间排序
        lqw.orderByAsc(DepartmentActivity::getId);//时间相同则按照id进行排序
        departmentActivityMapper.selectPage(List, lqw);
        GetShowList(List, type, show);
        //缓存10分钟过期
        stringRedisTemplate.opsForValue().set("cache:Double:departmentActivityList:search:"+page+","+limit+","+key, JSON.toJSONString(show),10, TimeUnit.MINUTES);
        return show;
    }

    /**
     * 展示详情页
     * @param id
     * @return
     */
    @Override
    public ApiResult<DepartmentActivityDetailVO> GetDepartmentActivityDetail(Integer id) {
        String departmentActivityVO = stringRedisTemplate.opsForValue().get("cache:Double:departmentActivity:detail:"+id);
        if (StrUtil.isNotBlank(departmentActivityVO)) {
            DepartmentActivityDetailVO cache= JSON.parseObject(departmentActivityVO,DepartmentActivityDetailVO.class);
            return ApiResult.success(cache);
        }
        DepartmentActivity departmentActivity=departmentActivityMapper.selectOne(
                new LambdaQueryWrapper<DepartmentActivity>()
                .eq(DepartmentActivity::getDictDeletedName,"未删除")
        .eq(DepartmentActivity::getId,id));
        if(departmentActivity==null){
            return ApiResult.failed("暂无此id的数据");
        }
        DepartmentActivityDetailVO vo=DepartmentActivityDetailVO.builder()
                .id(id)
                .title(departmentActivity.getTitle())
                .departmentName(departmentActivity.getDictCollegeName())
                .viewCount(departmentActivity.getViewCount())
                .createTime(departmentActivity.getCreateTime())
                .content(departmentActivityDetailMapper.selectOne(
                        new LambdaQueryWrapper<DepartmentActivityDetail>()
                                .eq(DepartmentActivityDetail::getBaseCollegeInfoId,id))
                        .getContent())
                .build();
        //缓存半个小时过期
        stringRedisTemplate.opsForValue().set("cache:Double:departmentActivity:detail:"+id, JSON.toJSONString(vo),30, TimeUnit.MINUTES);
        return ApiResult.success(vo);
    }


    /**
     * 用于装配，
     * 将实体类转化为用于展示的简化版的对象
     *
     * @param List
     * @param type
     * @param show
     * @return
     */
    private ShowListVO<DepartmentActivityVO> GetShowList(Page<DepartmentActivity> List, Type type, ShowListVO<DepartmentActivityVO> show) {
        show.setType(type.getMessage());
        show.setTotalCount(List.getTotal());
        show.setPageSize(List.getSize());
        show.setTotalPage(List.getPages());
        show.setCurrPage(List.getCurrent());
        java.util.List<DepartmentActivityVO> list = new ArrayList<DepartmentActivityVO>();
        for (int i = 0; i < List.getRecords().size(); i++) {
            DepartmentActivityVO vo =DepartmentActivityVO.builder()
                    .id(List.getRecords().get(i).getId())
                    .title(List.getRecords().get(i).getTitle())
                    .type(type)
                    .departmentId(List.getRecords().get(i).getDictCollegeId())
                    .departmentName(List.getRecords().get(i).getDictCollegeName())
                    .createTime(List.getRecords().get(i).getCreateTime()).build();
            list.add(vo);
        }
        show.setList(list);
        return show;
    }
}
