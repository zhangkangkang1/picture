package com.picture.dao;

import com.picture.entity.PicturePO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PictureDao {

    public List<PicturePO> selectAll();

    public int addPicture(PicturePO picturePO);

    PicturePO selectPictureById(@Param("id") Long id);
}
