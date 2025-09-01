package com.ray.blog.controller;

import com.github.pagehelper.PageInfo;
import com.ray.blog.business.annotation.BusinessLog;
import com.ray.blog.business.entity.Link;
import com.ray.blog.business.enums.LinkSourceEnum;
import com.ray.blog.business.enums.ResponseStatus;
import com.ray.blog.business.enums.TemplateKeyEnum;
import com.ray.blog.business.service.MailService;
import com.ray.blog.business.service.SysLinkService;
import com.ray.blog.business.vo.LinkConditionVO;
import com.ray.blog.framework.exception.LinkException;
import com.ray.blog.framework.object.PageResult;
import com.ray.blog.framework.object.ResponseVO;
import com.ray.blog.util.RegexUtils;
import com.ray.blog.util.ResultUtil;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 友情链接
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://docs..me
 * @date 2018/4/24 14:37
 * @since 1.0
 */
@RestController
@RequestMapping("/link")
public class RestLinkController {
    @Autowired
    private SysLinkService linkService;
    @Autowired
    private MailService mailService;

    @RequiresPermissions("links")
    @PostMapping("/list")
    public PageResult list(LinkConditionVO vo) {
        PageInfo<Link> pageInfo = linkService.findPageBreakByCondition(vo);
        return ResultUtil.tablePage(pageInfo);
    }

    @RequiresPermissions("link:add")
    @PostMapping(value = "/add")
    @BusinessLog("添加友情链接")
    public ResponseVO add(Link link) {
        link.setSource(LinkSourceEnum.ADMIN);
        if (!RegexUtils.isUrl(link.getUrl())) {
            throw new LinkException("链接地址无效！");
        }
        linkService.insert(link);
        mailService.send(link, TemplateKeyEnum.TM_LINKS);
        return ResultUtil.success("成功");
    }

    @RequiresPermissions(value = {"link:batchDelete", "link:delete"}, logical = Logical.OR)
    @PostMapping(value = "/remove")
    @BusinessLog("删除友情链接")
    public ResponseVO remove(Long[] ids) {
        if (null == ids) {
            return ResultUtil.error(500, "请至少选择一条记录");
        }
        for (Long id : ids) {
            linkService.removeByPrimaryKey(id);
        }
        return ResultUtil.success("成功删除 [" + ids.length + "] 个友情链接");
    }

    @RequiresPermissions("link:get")
    @PostMapping("/get/{id}")
    @BusinessLog("获取友情链接详情")
    public ResponseVO get(@PathVariable Long id) {
        return ResultUtil.success(null, this.linkService.getByPrimaryKey(id));
    }

    @RequiresPermissions("link:edit")
    @PostMapping("/edit")
    @BusinessLog("编辑友情链接")
    public ResponseVO edit(Link link) {
        if (!RegexUtils.isUrl(link.getUrl())) {
            throw new LinkException("链接地址无效！");
        }
        try {
            linkService.updateSelective(link);
        } catch (Exception e) {
            e.printStackTrace();
            return ResultUtil.error("友情链接修改失败！");
        }
        return ResultUtil.success(ResponseStatus.SUCCESS);
    }

}
