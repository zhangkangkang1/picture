package com.picture.entity;

import lombok.Data;
import java.util.Date;

@Data
public class PicturePO {

    private Long pictureId;

    private String pictureName;

    private String picturePath;

    private String pictureBase64;

    private String pictureRemark;

    private Date createDate;

    private Integer themeId;



}
