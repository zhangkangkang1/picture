package com.picture.controller;

import com.picture.entity.PicturePO;
import com.picture.service.PictureService;
import com.picture.utils.FileUtils;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@Api(tags = "图片服务")
@RestController
@Slf4j
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @CrossOrigin
    @PostMapping("/picture/selectAll")
    public List<PicturePO> selectAll() {
        List<PicturePO> picturePOList = pictureService.selectAll();
        return picturePOList;
    }

    @CrossOrigin
    @PostMapping("/picture/selectPictureById")
    public PicturePO selectPictureById(@RequestParam("id") Long id) {
        PicturePO picturePO = pictureService.selectPictureById(id);
        System.out.println(picturePO);
        return picturePO;
    }

    @CrossOrigin
    @GetMapping("/picture/test")
    public void test(HttpServletResponse response) {
        File file = new File("E:\\用电项目\\7月份\\marklion_用采GIS-6.23\\a.html");//本地生成的文件

        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(file);
            byte[] data = new byte[(int) file.length()];
            int length = inputStream.read(data);
            inputStream.close();
            //setContentType("text/plain; charset=utf-8"); 文本
            response.setContentType("text/html;charset=utf-8");
            OutputStream stream = response.getOutputStream();
            stream.write(data);
            stream.flush();
            stream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
