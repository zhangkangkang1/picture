package com.picture.service;

import com.picture.entity.PicturePO;

import java.util.List;

public interface PictureService {

    List<PicturePO> selectAll();

    int addPicture(PicturePO picturePO);

    PicturePO selectPictureById(Long id);
}
