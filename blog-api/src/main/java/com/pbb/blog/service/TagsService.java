package com.pbb.blog.service;

import com.pbb.blog.vo.TagVo;

import java.util.List;

/**
 * @author: admin
 * @date: 2022/3/1 10:45
 * @description:
 */
public interface TagsService {
    List<TagVo> findTagsByArticleId(Long id);
}
