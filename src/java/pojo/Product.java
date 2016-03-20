/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Hossam
 */
public class Product {

    private int id;
    private String name;
    private int quantity;
    private byte[] image;
    private int price;
    private int categoryId;
    private String description;

    public Product() {

    }

    public Product(int id) {
        setId(id);
    }

    public Product(int id, int catId, String name, int price, int quantity, String description) {
        setId(id);
        setCategoryId(catId);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setDescription(description);

    }

    public Product(int catId, String name, int price, int quantity, String description) {
        setCategoryId(catId);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
        setDescription(description);

    }

    public Product(int catId, String name, int price, int quantity) {
        setCategoryId(catId);
        setName(name);
        setPrice(price);
        setQuantity(quantity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
