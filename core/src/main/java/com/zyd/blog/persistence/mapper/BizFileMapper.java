package com.zyd.blog.persistence.mapper;

import com.zyd.blog.business.vo.FileConditionVO;
import com.zyd.blog.persistence.beans.BizFile;
import com.zyd.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BizFileMapper extends BaseMapper<BizFile> {

    List<BizFile> findPageBreakByCondition(FileConditionVO vo);
}
