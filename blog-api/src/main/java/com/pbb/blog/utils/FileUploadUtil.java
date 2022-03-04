package com.pbb.blog.utils;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * @author: admin
 * @date: 2022/3/4 15:31
 * @description:
 * @Version: 1.0
 */
public class FileUploadUtil {

    public boolean  fileUpload(CommonsMultipartFile file) throws IOException {

        //上传路径保存设置
        //String path = request.getServletContext().getRealPath("/upload");
/*        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }*/
        //上传文件地址
        System.out.println("文件名：" + file.getOriginalFilename());

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        file.transferTo(new File("D:\\Github\\myblog\\download" + file.getOriginalFilename()));

        return true;
    }


}
