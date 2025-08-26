package com.ray.blog.persistence.mapper;

import com.ray.blog.persistence.beans.SysConfig;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.Map;


@Repository
public interface SysConfigMapper extends BaseMapper<SysConfig> {
    Map<String, Object> getSiteInfo();
}
