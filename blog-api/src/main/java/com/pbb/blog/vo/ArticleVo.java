package com.pbb.blog.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: admin
 * @date: 2022/3/1 10:45
 * @description:
 */
@Data
public class ArticleVo {
    private Long id;

    private String title;

    private String summary;

    private int commentCounts;

    private int viewCounts;

    private int weight;
    /**
     * 创建时间
     */
    private String createDate;

    private String author;

    private ArticleBodyVo body;

    private List<TagVo> tags;

    private List<CategoryVo> categorys;
}
