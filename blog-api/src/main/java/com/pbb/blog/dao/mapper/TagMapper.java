package com.pbb.blog.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.pbb.blog.dao.pojo.Tag;

import java.util.List;

public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 查询最热的标签前n条
     * @param tagIds
     * @return
     */

    List<Tag> findTagsByTagIds(Long tagIds);
}
