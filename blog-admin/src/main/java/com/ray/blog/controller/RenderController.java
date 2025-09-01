package com.ray.blog.controller;

/**
 * 页面渲染相关 -- 页面跳转
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://docs..me
 * @date 2018/4/24 14:37
 * @since 1.0
 */

import com.ray.blog.business.annotation.BusinessLog;
import com.ray.blog.business.entity.Article;
import com.ray.blog.business.enums.AdPositionEnum;
import com.ray.blog.business.enums.AdTypeEnum;
import com.ray.blog.business.service.BizArticleService;
import com.ray.blog.core.websocket.server.rayWebsocketServer;
import com.ray.blog.framework.exception.Exception;
import com.ray.blog.util.ResultUtil;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.authz.annotation.RequiresUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * 页面跳转类
 *
 * @author yadong.zhang (yadong.zhang0415(a)gmail.com)
 * @version 1.0
 * @website https://docs..me
 * @date 2018/4/24 14:37
 * @since 1.0
 */
@Controller
public class RenderController {

    @Autowired
    private BizArticleService articleService;
    @Autowired
    private rayWebsocketServer websocketServer;

    @RequiresAuthentication
    @BusinessLog("进入首页")
    @GetMapping(value = {""})
    public ModelAndView home() {
        return ResultUtil.view("index");
    }

    @RequiresPermissions("users")
    @BusinessLog("进入用户列表页")
    @GetMapping("/users")
    public ModelAndView user() {
        return ResultUtil.view("user/list");
    }

    @RequiresPermissions("resources")
    @BusinessLog("进入资源列表页")
    @GetMapping("/resources")
    public ModelAndView resources() {
        return ResultUtil.view("resources/list");
    }

    @RequiresPermissions("roles")
    @BusinessLog("进入角色列表页")
    @GetMapping("/roles")
    public ModelAndView roles() {
        return ResultUtil.view("role/list");
    }

    @RequiresPermissions("articles")
    @BusinessLog("进入文章列表页")
    @GetMapping("/articles")
    public ModelAndView articles() {
        return ResultUtil.view("article/list");
    }

    @RequiresPermissions("article:publish")
    @BusinessLog(value = "进入发表文章页[{1}]")
    @GetMapping("/article/publish-{type}")
    public ModelAndView publish(@PathVariable("type") String type) {
        if (!Arrays.asList("we", "md", "tiny").contains(type)) {
            throw new Exception("不支持的编辑器类型");
        }
        return ResultUtil.view("article/publish-" + type);
    }

    @RequiresPermissions("article:publish")
    @BusinessLog(value = "进入修改文章页[id={1}]")
    @GetMapping("/article/update/{id}")
    public ModelAndView edit(@PathVariable("id") Long id, Model model) {
        model.addAttribute("id", id);
        Article article = articleService.getByPrimaryKey(id);

        if (!Arrays.asList("we", "md", "tiny").contains(article.getEditorType())) {
            throw new Exception("文章异常，未知的编辑器类型");
        }
        return ResultUtil.view("article/publish-" + article.getEditorType());
    }

    @RequiresPermissions("types")
    @BusinessLog("进入分类列表页")
    @GetMapping("/article/types")
    public ModelAndView types() {
        return ResultUtil.view("article/types");
    }

    @RequiresPermissions("tags")
    @BusinessLog("进入标签列表页")
    @GetMapping("/article/tags")
    public ModelAndView tags() {
        return ResultUtil.view("article/tags");
    }

    @RequiresPermissions("links")
    @BusinessLog("进入链接页")
    @GetMapping("/links")
    public ModelAndView links() {
        return ResultUtil.view("link/list");
    }

    @RequiresPermissions("comments")
    @BusinessLog("进入评论页")
    @GetMapping("/comments")
    public ModelAndView comments() {
        return ResultUtil.view("comment/list");
    }

    @RequiresPermissions("notices")
    @BusinessLog("进入系统通知页")
    @GetMapping("/notices")
    public ModelAndView notices() {
        return ResultUtil.view("notice/list");
    }

    @RequiresRoles("role:root")
    @BusinessLog("进入系统配置页")
    @GetMapping("/config")
    public ModelAndView config() {
        return ResultUtil.view("config");
    }

    @RequiresPermissions("templates")
    @BusinessLog("进入模板管理页")
    @GetMapping("/templates")
    public ModelAndView templates() {
        return ResultUtil.view("template/list");
    }

    @RequiresPermissions("updateLogs")
    @BusinessLog("进入更新记录管理页")
    @GetMapping("/updates")
    public ModelAndView updates() {
        return ResultUtil.view("update/list");
    }

    @RequiresPermissions("icons")
    @BusinessLog(value = "进入icons页")
    @GetMapping("/icons")
    public ModelAndView icons(Model model) {
        return ResultUtil.view("other/icons");
    }

    @RequiresPermissions("shiro")
    @BusinessLog(value = "进入shiro示例页")
    @GetMapping("/shiro")
    public ModelAndView shiro(Model model) {
        return ResultUtil.view("other/shiro");
    }

    @RequiresUser
    @BusinessLog("进入编辑器测试用例页面")
    @GetMapping("/editor")
    public ModelAndView editor(Model model) {
        return ResultUtil.view("other/editor");
    }

    @RequiresPermissions("notice")
    @BusinessLog("进入通知管理页")
    @GetMapping("/notice")
    public ModelAndView notice(Model model) {
        model.addAttribute("online", websocketServer.getOnlineUserCount());
        return ResultUtil.view("laboratory/notification");
    }

    @RequiresPermissions("files")
    @BusinessLog("进入文件管理页面")
    @GetMapping("/files")
    public ModelAndView files(Model model) {
        return ResultUtil.view("file/list");
    }

    @RequiresPermissions("socials")
    @BusinessLog("进入社会化登录配置管理页面")
    @GetMapping("/socials")
    public ModelAndView socials(Model model) {
        return ResultUtil.view("social/list");
    }

    @RequiresPermissions("page")
    @BusinessLog("进入配置自定义页面")
    @GetMapping("/page")
    public ModelAndView page(Model model) {
        return ResultUtil.view("page/page");
    }

    @RequiresPermissions("bizAds")
    @BusinessLog("进入广告页面")
    @GetMapping("/bizAd")
    public ModelAndView bizAd(Model model) {
        model.addAttribute("positions", AdPositionEnum.toListMap());
        model.addAttribute("types", AdTypeEnum.toListMap());
        return ResultUtil.view("bizAd/bizAd");
    }

}
