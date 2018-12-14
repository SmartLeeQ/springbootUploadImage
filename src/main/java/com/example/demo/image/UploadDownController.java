package com.example.demo.image;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;
import java.util.UUID;


@RestController
public class UploadDownController {
    @RequestMapping(value = "/uploadImage",method = RequestMethod.POST)
    public String uploadImage(@RequestParam(value = "file") MultipartFile file) {

        String fileName = file.getOriginalFilename();

        String filePath = "/Users/lixiaoqiang/Documents/JAVA/image/";

        fileName = filePath+ UUID.randomUUID() +fileName;

        File dest = new File(fileName);
        // 创建路径
        if(!dest.getParentFile().exists()){
            dest.getParentFile().mkdir();
        }
        try {
            file.transferTo(dest);
            return "上传成功";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "上传失败";
    }
}

