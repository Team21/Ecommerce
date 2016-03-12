/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchpkg;

/**
 *
 * @author islam
 */
public class resultArray {

    private resultArray[] rsa;

    public resultArray[] getRsa() {
        return rsa;
    }

    public void setRsa(resultArray[] rsa) {
        this.rsa = rsa;
    }
    private int productId;

    private String productName;

    private int productCategoryId;

    private int categoryId;

    private String categoryName;

    /**
     * Get the value of categoryName
     *
     * @return the value of categoryName
     */
    public String getCategoryName() {
        return categoryName;
    }

    /**
     * Set the value of categoryName
     *
     * @param categoryName new value of categoryName
     */
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    /**
     * Get the value of categoryId
     *
     * @return the value of categoryId
     */
    public int getCategoryId() {
        return categoryId;
    }

    /**
     * Set the value of categoryId
     *
     * @param categoryId new value of categoryId
     */
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    /**
     * Get the value of productCategoryId
     *
     * @return the value of productCategoryId
     */
    public int getProductCategoryId() {
        return productCategoryId;
    }

    /**
     * Set the value of productCategoryId
     *
     * @param productCategoryId new value of productCategoryId
     */
    public void setProductCategoryId(int productCategoryId) {
        this.productCategoryId = productCategoryId;
    }

    /**
     * Get the value of productName
     *
     * @return the value of productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * Set the value of productName
     *
     * @param productName new value of productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * Get the value of productId
     *
     * @return the value of productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Set the value of productId
     *
     * @param productId new value of productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

}
