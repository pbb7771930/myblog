package com.pbb.blog.service.impl;

import com.pbb.blog.dao.mapper.SysUserMapper;
import com.pbb.blog.dao.pojo.SysUser;
import com.pbb.blog.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: admin
 * @date: 2022/3/1 10:45
 * @description:
 */
public class SysUserServiceImpl implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser findUserById(Long id) {
        //根据id查询
        //为防止sysUser为空增加一个判断
        SysUser sysUser = sysUserMapper.selectById(id);
        if (sysUser == null){
            sysUser = new SysUser();
            sysUser.setNickname("码神之路");
        }
        return sysUser;
    }
}
