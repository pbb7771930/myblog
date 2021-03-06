package com.pbb.blog.controller;


import com.pbb.blog.dao.pojo.SysUser;
import com.pbb.blog.utils.UserThreadLocal;
import com.pbb.blog.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("test")
public class TestController {

    @RequestMapping
    public Result test(){
        SysUser sysUser = UserThreadLocal.get();
        System.out.println(sysUser);
        return Result.success(null);
    }
}
