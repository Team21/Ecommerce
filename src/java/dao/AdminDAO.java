/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.MysqlFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojo.Admin;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public class AdminDAO extends UserDAO {

    @Override
    public Object findObject(Object admin) {
        try {
            //open connection
            Connection connection = MysqlFactory.getConnection();
            String query = "SELECT * FROM users u, permission p WHERE username=? AND password=? AND u.permission_id=p.id LIMIT 1";//select user and check if 
            //prepared statement
            PreparedStatement pstmt = connection.prepareStatement(query);
            Admin a = (Admin) admin;
            pstmt.setString(1, a.getUserName());
            pstmt.setString(2, a.getPassword());
            ResultSet result = pstmt.executeQuery();
            if (result.next()) {
                String username = result.getString("username");
                String password = result.getString("password");
                String email = result.getString("email");
                String fname = result.getString("fname");
                String lname = result.getString("lname");
                String imageURL = result.getString("image_url");
                int permissionId = result.getInt("permission_id");
                a = new Admin(username, password, email, fname, lname, imageURL, permissionId);
            }
            query = "SELECT p.id FROM page_permission pp, page p WHERE pp.permission_id=? AND pp.page_id=p.id";//select page 
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, a.getPermissionId());
            result = pstmt.executeQuery();
            while (result.next()) {
                a.addPermissionId(result.getInt("id"));
            }
            return a;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
