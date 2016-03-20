/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.*;
import database.DBConnectionHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public class MysqlFactory extends DAOFactory {



    //connection here
    public static Connection getConnection() throws SQLException {
        return DBConnectionHandler.getInstance().getConnection();
    }
    
    public AdminDAO getAdmin() {
        return new AdminDAO();
    }

    public CategoryDAO getCategory() {
        return new CategoryDAO();
    }

    public InterestsDAO getInterests() {

        return new InterestsDAO();
    }

    public OrderDAO getOrder() {

        return new OrderDAO();
    }

    public PageDAO getPage() {

        return new PageDAO();
    }

    public PagePermissionDAO getPagePermission() {

        return new PagePermissionDAO();
    }

    public PermissionDAO getPermission() {

        return new PermissionDAO();
    }

    public ProductDAO getProduct() {

        return new ProductDAO();
    }

    public UserDAO getUser() {

        return new UserDAO();
    }
    
    public BillDAO getBill() {

        return new BillDAO();
    }
}
