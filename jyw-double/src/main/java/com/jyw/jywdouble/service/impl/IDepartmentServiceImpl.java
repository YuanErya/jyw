package com.jyw.jywdouble.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import cn.jyw.feign.common.api.Type;

import cn.jyw.feign.model.vo.ShowListVO;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.jyw.jywdouble.mapper.DepartmentMapper;
import com.jyw.jywdouble.model.Department;
import com.jyw.jywdouble.model.vo.DepartmentVO;
import com.jyw.jywdouble.service.IDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class IDepartmentServiceImpl extends ServiceImpl<DepartmentMapper, Department> implements IDepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 学院风采的的学院名字的展示
     *
     * @param page
     * @param limit
     * @return
     */
    @Override
    public ShowListVO<DepartmentVO> showList(Integer page, Integer limit) {
        //判断缓存中是否有
        String DepartmentVO = stringRedisTemplate.opsForValue().get("cache:departmentList:"+page+","+limit);
        if (StrUtil.isNotBlank(DepartmentVO)) {
            return JSON.parseObject(DepartmentVO, new TypeReference<ShowListVO<DepartmentVO>>(){});
        }
        ShowListVO<DepartmentVO> show = new ShowListVO<DepartmentVO>();
        Page<Department> departmentPage = new Page<Department>(page, limit);
        LambdaQueryWrapper<Department> lqw = new LambdaQueryWrapper<>();
        lqw.orderByAsc(Department::getId);//按照id进行排序
        departmentMapper.selectPage(departmentPage, lqw);
        show.setType(Type.departments_introduce.getMessage());
        show.setTotalCount(departmentPage.getTotal());
        show.setPageSize(departmentPage.getSize());
        show.setTotalPage(departmentPage.getPages());
        show.setCurrPage(departmentPage.getCurrent());
        List<DepartmentVO> list = new ArrayList<DepartmentVO>();
        for (int i = 0; i < departmentPage.getRecords().size(); i++) {
            DepartmentVO vo = new DepartmentVO();
            vo.setId(departmentPage.getRecords().get(i).getId());
            vo.setName(departmentPage.getRecords().get(i).getName());
            list.add(vo);
        }
        show.setList(list);
        //缓存1天过期
        stringRedisTemplate.opsForValue().set("cache:departmentList:"+page+","+limit, JSON.toJSONString(show),1, TimeUnit.DAYS);
        return show;
    }
}
