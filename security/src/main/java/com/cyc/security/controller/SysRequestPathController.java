package com.cyc.security.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyc.security.entity.SysRequestPath;
import com.cyc.security.service.SysRequestPathService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;import org.springframework.beans.factory.annotation.Autowired;


/**
 * 请求路径(SysRequestPath)表控制层
 *
 * @author makejava
 * @since 2020-08-04 16:14:14
 */
@RestController
@RequestMapping("sysRequestPath")
public class SysRequestPathController extends ApiController {
    /**
     * 服务对象
     */
    @Autowired
    private SysRequestPathService sysRequestPathService;

    /**
     * 分页查询所有数据
     *
     * @param page           分页对象
     * @param sysRequestPath 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysRequestPath> page, SysRequestPath sysRequestPath) {
        return success(this.sysRequestPathService.page(page, new QueryWrapper<>(sysRequestPath)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysRequestPathService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysRequestPath 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysRequestPath sysRequestPath) {
        return success(this.sysRequestPathService.save(sysRequestPath));
    }

    /**
     * 修改数据
     *
     * @param sysRequestPath 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysRequestPath sysRequestPath) {
        return success(this.sysRequestPathService.updateById(sysRequestPath));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysRequestPathService.removeByIds(idList));
    }
}