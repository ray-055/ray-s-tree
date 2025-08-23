package com.zyd.blog.persistence.mapper;

import com.zyd.blog.persistence.beans.BizArticleArchives;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BizArticleArchivesMapper {

    List<BizArticleArchives> listArchives();
}
