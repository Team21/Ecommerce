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
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;
import pojo.Permission;
import pojo.User;

/**
 *
 * @author AndDeve
 */
public class PermissionDAO implements DAOInter {

    Statement stmt;
    ResultSet resultSet;
    Connection connection;
    String sql;
    PreparedStatement ps;

    @Override
    public int insertObject(Object obj) {
        Permission p = (Permission) obj;
        int rows = 0;
        try {
            connection = MysqlFactory.getConnection();

            sql = "insert into permission (name,description) values(?,?) ";
            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getDescription());
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
        Permission p = (Permission) obj;
        sql = "SELECT * FROM permission WHERE name = ?";
        try {
            connection = MysqlFactory.getConnection();

            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            resultSet = ps.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("Permission Not Exist");
                return null;
            } else {
                resultSet.next();
                p = new Permission();
                p.setDescription(resultSet.getString("description"));
                p.setName(resultSet.getString("name"));
                p.setId(resultSet.getInt("id"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
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

}
