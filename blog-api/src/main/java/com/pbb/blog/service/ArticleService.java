package com.pbb.blog.service;

import com.pbb.blog.vo.ArticleVo;
import com.pbb.blog.vo.Result;
import com.pbb.blog.vo.params.PageParams;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author: admin
 * @date: 2022/3/1 10:45
 * @description:
 */
public interface ArticleService {
    /**
     * 分页查询文章列表
     * @param pageParams
     * @return
     */

    Result listArticles(PageParams pageParams);
}
