package com.example.codeclan.capstoneproject.Campagna.models.products;

import com.example.codeclan.capstoneproject.Campagna.models.user.Farmer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name="foods")
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "foodtype")
    private FoodType foodType;

    @Column(name = "size")
    private int sizePerUnit;

    @Column(name = "measurementUnit")
    private String measurementUnit;

    @Column(name = "description")
    private String description;

    @Column(name ="img_url")
    private String imageUrl;

    @ManyToOne
    @JsonIgnoreProperties({"foods"})
    @JoinColumn(name = "farmer_id")
    private Farmer farmer;

    public Food(String name, int price, FoodType foodType, int sizePerUnit, String description, String imageUrl, Farmer farmer) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.foodType = foodType;
        this.measurementUnit = this.foodType.getMeasureUnit();
        this.sizePerUnit = sizePerUnit;
        this.imageUrl = imageUrl;
        this.farmer = farmer;
    }

    public Food() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FoodType getFoodType() {
        return foodType;
    }

    public void setFoodType(FoodType foodType) {
        this.foodType = foodType;
    }

    public int getSizePerUnit() {
        return sizePerUnit;
    }

    public void setSizePerUnit(int sizePerUnit) {
        this.sizePerUnit = sizePerUnit;
    }

    // printSizeInfo: This method returns a string with the full size info (i.e. 500g, or 70cl)
    public String printSizeInfo(){
        return String.valueOf(this.sizePerUnit) + this.foodType.getMeasureUnit();
    }

    public Farmer getFarmer() {
        return farmer;
    }

    public void setFarmer(Farmer farmer) {
        this.farmer = farmer;
    }

    public String getMeasurementUnit() {
        return measurementUnit;
    }

    public void setMeasurementUnit(String measurementUnit) {
        this.measurementUnit = measurementUnit;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
