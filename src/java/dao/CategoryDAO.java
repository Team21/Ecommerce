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
import pojo.Permission;
import pojo.Product;

/**
 *
 * @author Hossam
 */
public class CategoryDAO implements DAOInter {

    Statement stmt;
    ResultSet resultSet;
    Connection connection;
    String sql;
    PreparedStatement ps;

    @Override
    public int insertObject(Object obj) {
        Category c = (Category) obj;
        int rows = 0;
        try {
            connection = MysqlFactory.getConnection();

            sql = "insert into category (name) values(?) ";
            ps = connection.prepareStatement(sql);
            ps.setString(1, c.getName());
            //ps.setBytes(2, c.getImage());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PermissionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    @Override
    public boolean deleteObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findObject(Object obj) {
        Category c = (Category) obj;
        sql = "SELECT * FROM category WHERE name = ?";
        try {
            connection = MysqlFactory.getConnection();

            ps = connection.prepareStatement(sql);
            ps.setString(1, c.getName());
            resultSet = ps.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("Permission Not Exist");
                return null;
            } else {
                resultSet.next();
                c = new Category();
                c.setImage(resultSet.getBytes("image"));
                c.setName(resultSet.getString("name"));
                c.setId(resultSet.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }

    @Override
    public boolean updateObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RowSet selectObjectsRS(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection selectObjectsTO(Object obj) {
        ArrayList<Category> categorys = new ArrayList<>();
        sql = "select * from category";
        try {
            connection = MysqlFactory.getConnection();
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Category c = new Category();
                c.setId(resultSet.getInt("id"));
                c.setName(resultSet.getString("name"));
                Blob imgb = resultSet.getBlob("image");
                if (imgb != null) {
                    byte[] imageByte = imgb.getBytes(1, (int) imgb.length());
                    c.setImage(imageByte);
                }
                categorys.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(CategoryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorys;
    }

}
