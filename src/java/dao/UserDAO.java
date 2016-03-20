/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import database.DBConnectionHandler;
import factory.DAOFactory;
import factory.MysqlFactory;
import interfaces.DAOInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;
import pojo.Product;
import pojo.User;

/**
 *
 * @author Hossam
 */
public class UserDAO implements DAOInter {

    Statement stmt;
    ResultSet resultSet;
    Connection connection;
    String sql;
    PreparedStatement ps;

    @Override
    public int insertObject(Object obj) {
        User u = (User) obj;
        int rows = 0;
        try {
            connection = MysqlFactory.getConnection();

            sql = "insert into user (email,fname,lname,username,password,phone,paypal,address,permission_id,activated) values(?,?,?,?,?,?,?,?,?,?) ";
            ps = connection.prepareStatement(sql);
            ps.setString(1, u.getEmail());
            ps.setString(2, u.getfName());
            ps.setString(3, u.getlName());
            ps.setString(4, u.getUserName());
            ps.setString(5, u.getPassword());
            ps.setString(6, u.getPhone());
            ps.setInt(7, u.getPaypal());
            ps.setString(8, u.getAddress());
            ps.setInt(9, u.getPermissionId()); // permission (user = 1) (obj = 2)
            ps.setInt(10, 1); // activated
//            ps.setDate(11, user.getBirthdate()); // error convet util.Date to sql.Date
            //ps.setBytes(12, u.getImage());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    @Override
    public boolean deleteObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findObject(Object obj) {
        User userObj = (User) obj;
        sql = "select * from user where email=? ";
        try {
            connection = MysqlFactory.getConnection();

            ps = connection.prepareStatement(sql);
            ps.setString(1, userObj.getEmail());
            resultSet = ps.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("User Not Exist");
                return null;
            } else {
                resultSet.next();
                if (userObj.getPassword().equals(resultSet.getString("password"))) {
                    User u = new User();
                    u.setId(resultSet.getInt("id"));
                    u.setfName(resultSet.getString("fname"));
                    u.setlName(resultSet.getString("lname"));
                    u.setEmail(resultSet.getString("email"));
                    u.setAddress(resultSet.getString("address"));
                    u.setUserName(resultSet.getString("username"));
                    u.setPassword(resultSet.getString("password"));
                    u.setPhone(resultSet.getString("phone"));
                    u.setBirthdate(resultSet.getDate("birthdate"));
                    u.setPaypal(resultSet.getInt("paypal"));
                    u.setPermissionId(resultSet.getInt("permission_id"));
                    u.setActivated(resultSet.getInt("activated"));

                    Blob imgb = resultSet.getBlob("image");
                    if (imgb != null) {
                        byte[] imageByte = imgb.getBytes(1, (int) imgb.length());
                        u.setImage(imageByte);
                    }
                    return u;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getUserID(String email) {
        sql = "select id from user where email=? ";
        int id = 0;
        try {
            connection = MysqlFactory.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setString(1, email);
            resultSet = ps.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("User Not Exist");
                return 0;
            } else {
                resultSet.next();
                id = resultSet.getInt("id");
                return id;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
