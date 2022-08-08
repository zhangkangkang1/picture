package com.picture.service.impl;

import com.picture.dao.PictureDao;
import com.picture.entity.PicturePO;
import com.picture.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
