/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import com.mysql.jdbc.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

/**
 *
 * @author AndDeve
 */
public class DBConnectionHandler {

    /*
     Singleton pattern
     intializes db getConnection and disconnect
     */
    private static String conParam = "jdbc:mysql://127.0.0.1:3306/servletsdb",
            user = "root",
            pass = "null";
    private static Connection con;

    private static DBConnectionHandler connector;
    private BoneCP connectionPool;

    private DBConnectionHandler() throws SQLException {
        DriverManager.registerDriver(new Driver());
        try {
            // setup the connection pool using BoneCP Configuration
            BoneCPConfig config = new BoneCPConfig();
            // jdbc url specific to your database, eg jdbc:mysql://127.0.0.1/yourdb
            config.setJdbcUrl(conParam);
            config.setUsername(user);
            config.setPassword(pass);
            config.setMinConnectionsPerPartition(5);
            config.setMaxConnectionsPerPartition(10);
            config.setPartitionCount(1);
            // setup the connection pool
            connectionPool = new BoneCP(config);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        //con = DriverManager.getConnection(conParam, user, pass);
    }

    public static DBConnectionHandler getInstance() throws SQLException {
        if (connector == null) {
            connector = new DBConnectionHandler();
        }
        //return connector.con;
        return connector;
    }
    
     public Connection getConnection() throws SQLException {
        return this.connectionPool.getConnection();
    }

    public static void disconnect() throws SQLException {
        con.close();
        connector = null;
    }

}
