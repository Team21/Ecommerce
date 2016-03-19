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
import pojo.Order;
import pojo.Product;

/**
 *
 * @author Hossam
 */
public class OrderDAO implements DAOInter {

    Statement stmt;
    ResultSet resultSet;
    Connection connection;
    String sql;
    PreparedStatement ps;

    @Override
    public int insertObject(Object obj) {
        Order o = (Order) obj;
        int rows = 0;
        try {
            connection = MysqlFactory.getConnection();
            sql = "insert into order (bill_id,product_id,quantity) values(?,?,?) ";
            ps = connection.prepareStatement(sql);
            ps.setInt(1, o.getBillId());
            ps.setInt(2, o.getProductId());
            ps.setInt(3, o.getQuantity());
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
    public Object findObject(Object admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public Collection selectObjectsTO(Object obj) {
        ArrayList<Order> orders = new ArrayList<>();
        sql = "select * from `servletsdb`.`order`";
        try {
            connection = MysqlFactory.getConnection();
            ps = connection.prepareStatement(sql);
            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                Order o = new Order();
                o.setBillId(resultSet.getInt("bill_id"));
                o.setQuantity(resultSet.getInt("quantity"));
                o.setProductId(resultSet.getInt("product_id"));
                orders.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orders;
    }

}
