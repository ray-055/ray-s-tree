package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.ResourceConditionVO;
import com.ray.blog.persistence.beans.SysResources;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository
public interface SysResourceMapper extends BaseMapper<SysResources> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    List<SysResources> findPageBreakByCondition(ResourceConditionVO vo);

    List<SysResources> listUserResources(Map<String, Object> map);

    List<SysResources> queryResourcesListWithSelected(Long rid);

    List<SysResources> listUrlAndPermission();

    List<SysResources> listAllAvailableMenu();

    List<SysResources> listByUserId(Long userId);
}
