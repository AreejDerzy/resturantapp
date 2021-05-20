package com.example.resturant.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="mealimage")
public class mealImage implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int imageId;

    public int getimageId() { return imageId; }

    public void setimageId(int userId) { this.imageId = imageId; }
    ////////////////////////////////////////////
    @Lob
    @Column(name = "meal_image_url")
    private String imageurl;

    public String getimageurl() { return imageurl; }

    public void setimageurl(String imageurl) { this.imageurl  = imageurl; }
    ////////////////////////////////////////////

    @Column(name = "meal_image_size")
    private int imageSize;

    public int getimageSize() { return imageSize; }

    public void setimageSize(int imageSize) { this.imageSize = imageSize; }
    ////////////////////////////////////////////

    @Column(name = "meal_image_name")
    private String imageName;

    public String getimageName() { return imageName; }

    public void setimageName(String imageName) { this.imageName = imageName; }
    ////////////////////////////////////////////

    @Column(name = "meal_id")
    private int mealId;

    public int getmealId() { return mealId; }

    public void setmealId(int mealId) { this.mealId = mealId; }
    ////////////////////////////////////////////

}
