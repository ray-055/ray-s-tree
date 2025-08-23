package com.zyd.blog.persistence.mapper;

import com.zyd.blog.business.vo.SocialConfigConditionVO;
import com.zyd.blog.persistence.beans.SysSocialConfig;
import com.zyd.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysSocialConfigMapper extends BaseMapper<SysSocialConfig>{

    List<SysSocialConfig> findPageBreakByCondition(SocialConfigConditionVO vo);

    SysSocialConfig getByClientId(String clientId);

    List<SysSocialConfig> listAvailable();
}
