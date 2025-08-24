package com.ray.blog.business.service;


import com.github.pagehelper.PageInfo;
import com.ray.blog.business.entity.Log;
import com.ray.blog.business.enums.PlatformEnum;
import com.ray.blog.business.vo.LogConditionVO;
import com.ray.blog.framework.object.AbstractService;
import org.springframework.web.context.request.ServletRequestAttributes;

/**
 * @author yadong.zhang email:yadong.zhang0415(a)gmail.com
 * @version 1.0
 * @date 2018/01/09 17:40
 * @since 1.0
 */
public interface SysLogService extends AbstractService<Log, Integer> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    PageInfo<Log> findPageBreakByCondition(LogConditionVO vo);

    void asyncSaveSystemLog(PlatformEnum platform, String bussinessName, ServletRequestAttributes servletRequestAttributes);
}
