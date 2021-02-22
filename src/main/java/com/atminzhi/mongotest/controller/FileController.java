package com.atminzhi.mongotest.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.*;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/file")
public class FileController {
    private static Logger logger = LoggerFactory.getLogger(FileController.class);
    @Value("${filepath}")
    private String filepath;

    /**
     * 处理文件上传
     */
    @PostMapping(value = "/upload")
    public String uploading(@RequestParam("file") MultipartFile file) {
//        File targetFile = new File(filepath);
//        if (!targetFile.exists()) {
//            targetFile.mkdirs();
//        }
        try {
                //文件输出流
//            String originalFilename =UUID.randomUUID().toString()+file.getOriginalFilename();
            String originalFilename =System.currentTimeMillis()+file.getOriginalFilename();
            //格式化当前日期
            Date data = new Date();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String now = format.format(data);
            filepath = filepath+now+"/";
            //若该目录不存在则创建该目录
            File targetFile = new File(filepath);
            if (!targetFile.exists()) {
                targetFile.mkdirs();
            }
            FileOutputStream out = new FileOutputStream(filepath +  originalFilename);
            System.out.println(targetFile);
            System.out.println("文件名："+originalFilename);
                out.write(file.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("文件上传失败!");
            return "uploading failure";
        }
        logger.info("文件上传成功!");
        return "uploading success";
    }

    @RequestMapping("/download")
    public void downLoad(HttpServletResponse response) throws UnsupportedEncodingException {
        String filename="1611214292159面试提纲.png";
        String filePath = "D:/fileyyy/save/2021-01-21" ;
        File file = new File(filePath + "/" + filename);
        if(file.exists()){
            response.setContentType("application/octet-stream");
            response.setHeader("content-type", "application/octet-stream");
            response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(filename,"utf8"));
            byte[] buffer = new byte[1024];
            //输出流
            OutputStream os = null;
            try(
                    //文件输入流
                FileInputStream fis= new FileInputStream(file);
                BufferedInputStream bis = new BufferedInputStream(fis);) {
                os = response.getOutputStream();
                int i = bis.read(buffer);
                while(i != -1){
                    os.write(buffer);
                    i = bis.read(buffer);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
