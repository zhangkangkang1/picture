package com.picture.controller;

import com.picture.entity.PicturePO;
import com.picture.service.PictureService;
import com.picture.utils.FileUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@Slf4j
public class PictureController {
    @Autowired
    private PictureService pictureService;

    @RequestMapping(value = "/picture/selectAll", method = RequestMethod.POST)
    @CrossOrigin
    public List<PicturePO> selectAll() {
        List<PicturePO> picturePOList = pictureService.selectAll();
        return picturePOList;
    }

    @RequestMapping(value = "/picture/selectPictureById", method = RequestMethod.POST)
    @CrossOrigin
    public PicturePO selectPictureById(@RequestParam("id") Long id) {
        PicturePO picturePO = pictureService.selectPictureById(id);
        System.out.println(picturePO);
        return picturePO;
    }

    @RequestMapping(value = "/picture/upload", method = RequestMethod.POST)
    @CrossOrigin
    public String uploadPicture(@RequestParam("file") MultipartFile file) {
        String result = pictureService.uploadPicture(file);
         return result;
    }

}