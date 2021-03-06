/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import factory.MysqlFactory;
import interfaces.DAOInter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.RowSet;
import pojo.Page;
import pojo.Permission;


/**
 *
 * @author AndDeve
 */
public class PageDAO implements DAOInter{

    Statement stmt;
    ResultSet resultSet;
    Connection connection;
    String sql;
    PreparedStatement ps;
    
    @Override
    public int insertObject(Object obj) {
        Page p = (Page) obj;
        int rows = 0;
        try {
            connection = MysqlFactory.getConnection();

            sql = "insert into page (name) values(?) ";
            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            rows = ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PermissionDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rows;
    }

    @Override
    public boolean deleteObject(Object admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findObject(Object obj) {
        Page p = (Page) obj;
        sql = "SELECT * FROM page WHERE name = ?";
        try {
            connection = MysqlFactory.getConnection();

            ps = connection.prepareStatement(sql);
            ps.setString(1, p.getName());
            resultSet = ps.executeQuery();
            if (!resultSet.isBeforeFirst()) {
                System.out.println("Page Not Exist");
                return null;
            } else {
                resultSet.next();
                p = new Page();
                p.setName(resultSet.getString("name"));
                p.setId(resultSet.getInt("id"));
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
    public RowSet selectObjectsRS(Object admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection selectObjectsTO(Object admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
