package com.example.resturant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="userimage")
public class userImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int imageId;

    public int getimageId() { return imageId; }

    public void setimageId(int userId) { this.imageId = imageId; }
    ////////////////////////////////////////////
    @Lob
    @Column(name = "user_image_url")
    private String imageurl;

    public String getimageurl() { return imageurl; }

    public void setimageurl(String imageurl) { this.imageurl  = imageurl; }
    ////////////////////////////////////////////

    @Column(name = "user_image_size")
    private int imageSize;

    public int getimageSize() { return imageSize; }

    public void setimageSize(int imageSize) { this.imageSize = imageSize; }
    ////////////////////////////////////////////

    @Column(name = "user_image_name")
    private String imageName;

    public String getimageName() { return imageName; }

    public void setimageName(String imageName) { this.imageName = imageName; }
    ////////////////////////////////////////////

    @Column(name = "user_id")
    private int userId;

    public int getuserId() { return userId; }

    public void setuserId(int userId) { this.userId = userId; }
    ////////////////////////////////////////////

}
