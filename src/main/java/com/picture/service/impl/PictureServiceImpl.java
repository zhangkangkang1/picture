package com.picture.service.impl;

import com.picture.dao.PictureDao;
import com.picture.entity.PicturePO;
import com.picture.service.PictureService;
import com.picture.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureDao pictureDao;
    @Override
    public List<PicturePO> selectAll() {

        new Date();
        return pictureDao.selectAll();
    }

    @Override
    public int addPicture(PicturePO picturePO) {
        return pictureDao.addPicture(picturePO);
    }

    @Override
    public PicturePO selectPictureById(Long id) {
        return pictureDao.selectPictureById(id);
    }

    @Override
    public String uploadPicture(MultipartFile file) {

        String name = file.getName();
        String originalFilename = file.getOriginalFilename();
        String fileName = "";
        if (originalFilename.contains(".")) {
            int i = originalFilename.lastIndexOf(".");
            fileName = originalFilename.substring(0, i);
        }
        Resource resource = file.getResource();
        String base64 = "";
        try {
            base64 = FileUtils.fileToBase64(FileUtils.MtoF(file));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        PicturePO picturePO = new PicturePO();
        Date date = new Date();
        System.out.println(date);
        picturePO.setPictureId(Long.valueOf(System.currentTimeMillis()));
        picturePO.setPictureName(fileName);
        picturePO.setPictureBase64(base64);
        picturePO.setThemeId(1);
        picturePO.setPictureRemark("test");
        picturePO.setCreateDate(date);
        int i = pictureDao.addPicture(picturePO);
        // file.
        System.out.printf("file: " + file);
//        PicturePO picturePO = pictureService.selectPictureById(id);
//        System.out.println(picturePO);


        return "ok";
    }
}
