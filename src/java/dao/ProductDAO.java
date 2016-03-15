/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.MysqlFactory;
import interfaces.DAOInter;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;
import pojo.Category;
import pojo.Product;
import pojo.User;

/**
 *
 * @author Hossam
 */
public class ProductDAO implements DAOInter {

    Statement stmt;
    ResultSet resultSet;
    Connection connection;
    String sql;
    PreparedStatement ps;

    @Override
    public int insertObject(Object obj) {
        Product p = (Product) obj;
        int rows = 0;
        try {
            connection = MysqlFactory.getConnection();

            sql = "insert into product (name,quantity,price,category_id,description) values(?,?,?,?,?) ";
            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setInt(2, p.getQuantity());
            ps.setInt(3, p.getPrice());
            ps.setInt(4, p.getCategoryId());
            ps.setString(5, p.getDescription());
            //ps.setBytes(6, p.getImage());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    @Override
    public boolean deleteObject(Object admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findObject(Object obj) {
        Product p = (Product) obj;
        if (p.getName() != null) {
            return findObjectByName(p);
        } else {
            return findObjectByID(p);
        }
    }

    private Object findObjectByID(Product p) {
        sql = "select * from product where id=?";
        try {
            connection = MysqlFactory.getConnection();

            ps = connection.prepareStatement(sql);
            ps.setInt(1, p.getId());
            resultSet = ps.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("Product Not Exist");
                return null;
            } else {
                resultSet.next();

                p = new Product();
                p.setId(resultSet.getInt("id"));
                p.setName(resultSet.getString("name"));
                p.setQuantity(resultSet.getInt("quantity"));
                p.setPrice(resultSet.getInt("price"));
                p.setCategoryId(resultSet.getInt("category_id"));
                p.setDescription(resultSet.getString("description"));
                Blob imgb = resultSet.getBlob("image");
                System.out.println(imgb);
                if (imgb != null) {
                    byte[] imageByte = imgb.getBytes(1, (int) imgb.length());
                    System.out.println("image : " + imageByte);
                    p.setImage(imageByte);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    private Object findObjectByName(Product p) {
        sql = "select * from product where name=?";
        try {
            connection = MysqlFactory.getConnection();

            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            resultSet = ps.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("Product Not Exist");
                return null;
            } else {
                resultSet.next();

                p = new Product();
                p.setId(resultSet.getInt("id"));
                p.setName(resultSet.getString("name"));
                p.setQuantity(resultSet.getInt("quantity"));
                p.setPrice(resultSet.getInt("price"));
                p.setCategoryId(resultSet.getInt("category_id"));
                p.setDescription(resultSet.getString("description"));
                Blob imgb = resultSet.getBlob("image");
                System.out.println(imgb);
                if (imgb != null) {
                    byte[] imageByte = imgb.getBytes(1, (int) imgb.length());
                    System.out.println("image : " + imageByte);
                    p.setImage(imageByte);
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    public boolean updateObject(Object admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RowSet selectObjectsRS(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection selectObjectsTO(Object obj) {
        if (obj instanceof Category) {
            return selectObjectsByCategoryID((Category) obj);
        } else {
            ArrayList<Product> products = new ArrayList<>();
            sql = "select * from product";
            try {
                connection = MysqlFactory.getConnection();
                ps = connection.prepareStatement(sql);
                resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    Product p = new Product();
                    p.setId(resultSet.getInt("id"));
                    p.setName(resultSet.getString("name"));
                    p.setDescription(resultSet.getString("description"));
                    p.setQuantity(resultSet.getInt("quantity"));
                    p.setCategoryId(resultSet.getInt("category_id"));
                    p.setPrice(resultSet.getInt("price"));
                    Blob imgb = resultSet.getBlob("image");
                    System.out.println(imgb);
                    if (imgb != null) {
                        byte[] imageByte = imgb.getBytes(1, (int) imgb.length());
                        System.out.println("image : " + imageByte);
                        p.setImage(imageByte);

                    }
                    products.add(p);
                }

            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return products;
        }
    }

    private Collection selectObjectsByCategoryID(Category c) {
        ArrayList<Product> products = new ArrayList<>();
        sql = "select p.* from product p , category c WHERE p.category_id = c.id AND c.id =? ";
        try {
            connection = MysqlFactory.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, c.getId());
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Product p = new Product();
                p.setId(resultSet.getInt("id"));
                p.setName(resultSet.getString("name"));
                p.setDescription(resultSet.getString("description"));
                p.setQuantity(resultSet.getInt("quantity"));
                p.setCategoryId(resultSet.getInt("category_id"));
                p.setPrice(resultSet.getInt("price"));
                Blob imgb = resultSet.getBlob("image");
                System.out.println(imgb);
                if (imgb != null) {
                    byte[] imageByte = imgb.getBytes(1, (int) imgb.length());
                    System.out.println("image : " + imageByte);
                    p.setImage(imageByte);

                }
                products.add(p);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return products;
    }
}
