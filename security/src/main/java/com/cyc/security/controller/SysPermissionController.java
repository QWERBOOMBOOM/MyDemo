package com.cyc.security.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cyc.security.entity.SysPermission;
import com.cyc.security.service.SysPermissionService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;import org.springframework.beans.factory.annotation.Autowired;


/**
 * 权限表(SysPermission)表控制层
 *
 * @author makejava
 * @since 2020-08-04 16:14:02
 */
@RestController
@RequestMapping("sysPermission")
public class SysPermissionController extends ApiController {
    /**
     * 服务对象
     */
    @Autowired
    private SysPermissionService sysPermissionService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param sysPermission 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<SysPermission> page, SysPermission sysPermission) {
        return success(this.sysPermissionService.page(page, new QueryWrapper<>(sysPermission)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.sysPermissionService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param sysPermission 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody SysPermission sysPermission) {
        return success(this.sysPermissionService.save(sysPermission));
    }

    /**
     * 修改数据
     *
     * @param sysPermission 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody SysPermission sysPermission) {
        return success(this.sysPermissionService.updateById(sysPermission));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.sysPermissionService.removeByIds(idList));
    }
}