package com.ray.blog.persistence.mapper;

import com.ray.blog.business.vo.FileConditionVO;
import com.ray.blog.persistence.beans.BizFile;
import com.ray.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BizFileMapper extends BaseMapper<BizFile> {

    List<BizFile> findPageBreakByCondition(FileConditionVO vo);
}
