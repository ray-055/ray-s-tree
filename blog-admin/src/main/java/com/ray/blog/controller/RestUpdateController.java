package com.ray.blog.controller;

import com.github.pagehelper.PageInfo;
import com.ray.blog.business.annotation.BusinessLog;
import com.ray.blog.business.entity.UpdateRecorde;
import com.ray.blog.business.enums.ResponseStatus;
import com.ray.blog.business.service.SysUpdateRecordeService;
import com.ray.blog.business.vo.UpdateRecordeConditionVO;
import com.ray.blog.framework.object.PageResult;
import com.ray.blog.framework.object.ResponseVO;
import com.ray.blog.util.ResultUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 系统更新日志
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://docs..me
 * @date 2018/4/24 14:37
 * @since 1.0
 */
@RestController
@RequestMapping("/update")
public class RestUpdateController {
    @Autowired
    private SysUpdateRecordeService updateRecordeService;

    @RequiresPermissions("updateLogs")
    @PostMapping("/list")
    public PageResult list(UpdateRecordeConditionVO vo) {
        PageInfo<UpdateRecorde> pageInfo = updateRecordeService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    @RequiresPermissions("updateLog:add")
    @PostMapping(value = "/add")
    @BusinessLog("添加更新日志")
    public ResponseVO add(UpdateRecorde updateRecorde) {
        updateRecordeService.insert(updateRecorde);
        return ResultUtil.success("成功");
    }

    @RequiresPermissions(value = {"updateLog:batchDelete", "updateLog:delete"}, logical = Logical.OR)
    @PostMapping(value = "/remove")
    @BusinessLog("删除更新日志")
    public ResponseVO remove(Long[] ids) {
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        for (Long id : ids) {
            updateRecordeService.removeByPrimaryKey(id);
        }
        return ResultUtil.success("成功删除 [" + ids.length + "] 个更新记录");
    }

    @RequiresPermissions("updateLog:get")
    @PostMapping("/get/{id}")
    @BusinessLog("获取更新日志详情")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.updateRecordeService.getByPrimaryKey(id));
    }

    @RequiresPermissions("updateLog:edit")
    @PostMapping("/edit")
    @BusinessLog("编辑更新日志")
    public ResponseVO edit(UpdateRecorde updateRecorde) {
        try {
            updateRecordeService.updateSelective(updateRecorde);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("更新记录修改失败！");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }

}
