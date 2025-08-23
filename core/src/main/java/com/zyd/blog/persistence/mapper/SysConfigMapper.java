package com.zyd.blog.persistence.mapper;

import com.zyd.blog.persistence.beans.SysConfig;
import com.zyd.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface SysConfigMapper extends BaseMapper<SysConfig> {
    Map<String, Object> getSiteInfo();
}
