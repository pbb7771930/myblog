package com.pbb.blog.vo.params;

import lombok.Data;
/**
 * @author: admin
 * @date: 2022/3/1 10:45
 * @description:
 */
@Data
public class PageParams {
    private int page = 1;

    private int pageSize = 10;

    private Long categoryId;

    private Long tagId;
}
