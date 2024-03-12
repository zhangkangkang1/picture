package com.picture.service.impl;

import com.picture.dao.PictureDao;
import com.picture.entity.PicturePO;
import com.picture.service.PictureService;
import com.picture.utils.FileUtils;
import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

@Service
public class PictureServiceImpl implements PictureService {

    ThreadFactory basicThreadFactory = new BasicThreadFactory.Builder()
            .namingPattern("basicThreadFactory-").build();

    ExecutorService exec = new ThreadPoolExecutor(1, 1,
            0L, TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(10),basicThreadFactory);
//exec.submit(() -> {
//        logger.info("--记忆中的颜色是什么颜色---");
//});


    @Autowired
    private PictureDao pictureDao;
    @Override
    public List<PicturePO> selectAll() {
        List<PicturePO> picturePOS = pictureDao.selectAll();
        List<PicturePO> picturePOS1 = new ArrayList<>();
        picturePOS.forEach(item -> {
            String pictureBase64 = item.getPictureBase64();
            item.setPictureBase64("data:image/jpg;base64," + pictureBase64);
            picturePOS1.add(item);
        });
        return picturePOS1;
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
