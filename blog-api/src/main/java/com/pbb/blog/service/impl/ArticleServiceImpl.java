package com.pbb.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.pbb.blog.dao.mapper.ArticleMapper;
import com.pbb.blog.dao.pojo.Article;
import com.pbb.blog.service.ArticleService;
import com.pbb.blog.service.SysUserService;
import com.pbb.blog.service.TagsService;
import com.pbb.blog.vo.ArticleVo;
import com.pbb.blog.vo.Result;
import com.pbb.blog.vo.params.PageParams;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * @author: admin
 * @date: 2022/3/1 10:45
 * @description:
 */
@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    /*
     * @param pageParams:
     * @return: com.pbb.blog.vo.Result
     * @author: admin
     * @date: 2022/3/1 14:35
     * @description: 分页查询article数据库表
     */
    @Override
    public Result listArticles(PageParams pageParams) {
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //是否置顶进行排序,  时间倒序进行排列相当于order by create_data desc
        queryWrapper.orderByDesc(Article::getWeight,Article::getCreateDate);
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);

        //分页查询用法 https://blog.csdn.net/weixin_41010294/article/details/105726879
        List<Article> records = articlePage.getRecords();

        // 要返回我们定义的vo数据，就是对应的前端数据，不应该只返回现在的数据需要进一步进行处理
        List<ArticleVo> articleVoList =copyList(records,true,true);
        
        return Result.success(articleVoList);
        
    }
    
/**
 * @Author pbb
 * @description :
 * @date 2022/3/1 21:07
 * @Param [records, isTag, isAuthor]
 * @return java.util.List<com.pbb.blog.vo.ArticleVo>
 **/
    private List<ArticleVo> copyList(List<Article> records,boolean isTag,boolean isAuthor) {

        List<ArticleVo> articleVoList = new ArrayList<>();

        for (Article record : records) {
            articleVoList.add(copy(record,isTag,isAuthor));
        }
        return articleVoList;

    }
/**
 * @Author pbb
 * @description : //"eop的作用是对应copyList，集合之间的copy分解成集合元素之间的copy
 * @date 2022/3/1 21:12
 * @Param [article, isTag, isAuthor]
 * @return com.pbb.blog.vo.ArticleVo
 **/

    private ArticleVo copy(Article article, boolean isTag, boolean isAuthor){
        ArticleVo articleVo = new ArticleVo();
        //BeanUtils.copyProperties用法   https://blog.csdn.net/Mr_linjw/article/details/50236279
        BeanUtils.copyProperties(article, articleVo);
        articleVo.setCreateDate(new DateTime(article.getCreateDate()).toString("yyyy-MM-dd HH:mm"));
        //并不是所有的接口都需要标签和作者信息
        if(isTag){
            Long articleId = article.getId();
            articleVo.setTags(tagsService.findTagsByArticleId(articleId));
        }
        if (isAuthor) {
            //拿到作者id
            Long authorId = article.getAuthorId();

            articleVo.setAuthor(sysUserService.findUserById(authorId).getNickname());
        }
        return articleVo;

    }




/*    @Autowired
    private TagsService tagsService;
    @Autowired
    private SysUserService sysUserService;*/

/*    @Override
    public Result listArticlesPage(PageParams pageParams) {
        *//**
         * 1、分页查询article数据库表
         *//*
        Page<Article> page = new Page<>(pageParams.getPage(), pageParams.getPageSize());
        LambdaQueryWrapper<Article> queryWrapper = new LambdaQueryWrapper<>();
        //是否置顶进行排序,  时间倒序进行排列相当于order by create_data desc
        queryWrapper.orderByDesc(Article::getWeight,Article::getCreateDate);
        Page<Article> articlePage = articleMapper.selectPage(page, queryWrapper);

        //分页查询用法 https://blog.csdn.net/weixin_41010294/article/details/105726879
        List<Article> records = articlePage.getRecords();

        // 要返回我们定义的vo数据，就是对应的前端数据，不应该只返回现在的数据需要进一步进行处理
        List<ArticleVo> articleVoList =copyList(records,true,true);
        return Result.success(articleVoList);
    }*/





}
