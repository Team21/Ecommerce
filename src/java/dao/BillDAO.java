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
import pojo.Bill;
import pojo.Category;
import pojo.Product;
import pojo.User;

/**
 *
 * @author Hossam
 */
public class BillDAO implements DAOInter {

    Statement stmt;
    ResultSet resultSet;
    Connection connection;
    String sql;
    PreparedStatement ps;

    @Override
    public int insertObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object findObject(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        if (obj instanceof User) {
            return selectObjectsByUserID((User) obj);
        } else {
            ArrayList<Bill> bills = new ArrayList<>();
            sql = "select * from bill";
            try {
                connection = MysqlFactory.getConnection();
                ps = connection.prepareStatement(sql);
                resultSet = ps.executeQuery();

                while (resultSet.next()) {
                    Bill b = new Bill();
                    b.setId(resultSet.getInt("id"));
                    b.setBuyDate(resultSet.getDate("buy_date"));
                    b.setTotalPrice(resultSet.getInt("total_price"));
                    b.setUserID(resultSet.getInt("user_id"));
                    bills.add(b);
                }
            } catch (SQLException ex) {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return bills;
        }
    }

    private Collection selectObjectsByUserID(User u) {
        ArrayList<Bill> bills = new ArrayList<>();
        sql = "select * from bill WHERE user_id =? ";
        try {
            connection = MysqlFactory.getConnection();
            ps = connection.prepareStatement(sql);
            ps.setInt(1, u.getId());
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Bill b = new Bill();
                b.setId(resultSet.getInt("id"));
                b.setBuyDate(resultSet.getDate("buy_date"));
                b.setTotalPrice(resultSet.getInt("total_price"));
                b.setUserID(resultSet.getInt("user_id"));
                bills.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bills;
    }
}
