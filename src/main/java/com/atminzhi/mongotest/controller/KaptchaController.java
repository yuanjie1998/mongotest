package com.atminzhi.mongotest.controller;

import com.google.code.kaptcha.Producer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/KaptchaController")
public class KaptchaController {
    private Logger logger = LoggerFactory.getLogger(KaptchaController.class);

//    将在KaptchaConfig配置类中注入容器的方法实例装配
    @Autowired
    Producer kaptchaProducer;

    @GetMapping("/kaptcha")
    public void getKaptcha(HttpServletResponse response, HttpSession session){
        //生成验证码
        String text = kaptchaProducer.createText(); //生成4位的字符串，自己配置的内容
        BufferedImage image = kaptchaProducer.createImage(text);//生成图片

        //将验证码存入session
        session.setAttribute("kaptcha",text);

        //将图片输出给浏览器
        response.setContentType("image/png");
        try {
            OutputStream outputStream = response.getOutputStream();
            ImageIO.write(image,"png",outputStream);
            logger.info("响应验证码成功！");
        } catch (IOException e) {
            //捕获到异常便日志输出
           logger.error("响应验证码失败！" + e.getMessage());
        }
    }
}
