package com.pbb.blog.controller;

import com.pbb.blog.service.ArticleService;
import com.pbb.blog.vo.ArticleVo;
import com.pbb.blog.vo.Result;
import com.pbb.blog.vo.params.PageParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//Json数据交互
@RestController
@RequestMapping("articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    /**
     * @param pageParams:
     * @return: com.pbb.blog.vo.Result
     * @author: admin
     * @date: 2022/3/1 11:21
     * @description: 首页文章列表
     */
    @PostMapping
    public Result listArticle(@RequestBody PageParams pageParams) {
        //ArticleVo 页面接收的数据
        List<ArticleVo> articles = articleService.listArticlesPage(pageParams);

        return articleService.listArticlesPage(pageParams);
    }
}
