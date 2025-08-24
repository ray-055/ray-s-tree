package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.SocialConfigConditionVO;
import com.ray.blog.persistence.beans.SysSocialConfig;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysSocialConfigMapper extends BaseMapper<SysSocialConfig>{

    List<SysSocialConfig> findPageBreakByCondition(SocialConfigConditionVO vo);

    SysSocialConfig getByClientId(String clientId);

    List<SysSocialConfig> listAvailable();
}
