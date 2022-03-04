package com.pbb.blog.controller;

import com.pbb.blog.utils.FileUploadUtil;
import com.pbb.blog.vo.Result;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.io.IOException;
import java.util.UUID;

/*
 * @author: admin
 * @date: 2022/3/4 15:55
 * @description:这里用自己写的方法上传到本地，否则上传到托管的互联网上，需要用到指定平台的API
 */
@RestController
@RequestMapping("upload")
public class UploadController {

    @Autowired(required=false)
    private FileUploadUtil fileUploadUtil ;


    @PostMapping
    public Result upload(CommonsMultipartFile file) throws IOException {
        /*//原始文件名称 比如 aa.png
        String originalFilename = file.getOriginalFilename();
        //唯一的文件名称
        String modifyFileName = UUID.randomUUID().toString() + "." + StringUtils.substringAfterLast(originalFilename, ".");
        System.out.println("上传的文件名：" + modifyFileName);*/

        //上传文件
        boolean is_upload = fileUploadUtil.fileUpload(file);
        if (is_upload){
            return Result.success(file.getOriginalFilename());
        }
        return Result.fail(20001,"上传失败");
    }
}
