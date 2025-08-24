package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.UserConditionVO;
import com.ray.blog.persistence.beans.SysUser;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SysUserMapper extends BaseMapper<SysUser> {

    List<SysUser> findPageBreakByCondition(UserConditionVO vo);

    List<SysUser> listByRoleId(Long roleId);

}
