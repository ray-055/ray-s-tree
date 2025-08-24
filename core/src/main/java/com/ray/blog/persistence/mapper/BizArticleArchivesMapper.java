package com.ray.blog.persistence.mapper;

import com.ray.blog.persistence.beans.BizArticleArchives;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BizArticleArchivesMapper {

    List<BizArticleArchives> listArchives();
}
