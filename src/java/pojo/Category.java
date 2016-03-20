/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

import java.io.Serializable;

/**
 *
 * @author Hossam
 */
public class Category implements  Serializable{
    
    private int id;
    private String name;
    private byte[] image;
    
    public Category() {
    }
    public Category(int id, String name) {
        setId(id);
        setName(name);
    }
    
    public Category(String name) {
        
        setName(name);
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
    
    public byte[] getImage() {
        return image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }
    
}
