package com.pbb.blog.service;

import com.pbb.blog.vo.CategoryVo;
import com.pbb.blog.vo.Result;

public interface CategoryService {

    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    Result categoryDetailById(Long id);
}
