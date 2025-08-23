package com.zyd.blog.persistence.mapper;

import com.zyd.blog.business.vo.CommentConditionVO;
import com.zyd.blog.persistence.beans.BizComment;
import com.zyd.blog.plugin.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface BizCommentMapper extends BaseMapper<BizComment> {

    /**
     * 分页查询
     *
     * @param vo
     * @return
     */
    List<BizComment> findPageBreakByCondition(CommentConditionVO vo);

    /**
     * 点赞
     *
     * @param id
     */
    void doSupport(Long id);

    /**
     * 点踩
     *
     * @param id
     */
    void doOppose(Long id);

    /**
     * 获取单个评论，关联查询文章信息
     *
     * @param id
     */
    BizComment getById(Long id);
}
