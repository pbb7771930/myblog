package com.pbb.blog.service;

import com.pbb.blog.dao.pojo.SysUser;

/**
 * @author: admin
 * @date: 2022/3/1 10:45
 * @description:
 */
public interface SysUserService {
    SysUser findUserById(Long userId);
}
