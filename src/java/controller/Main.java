/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDAO;
import dao.UserDAO;
import factory.DAOFactory;
import factory.MysqlFactory;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import pojo.Bill;
import pojo.Order;
import pojo.Permission;
import pojo.User;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public class Main {

//    //example to get dao 
//    void foo() {
//
//        //get dao from factory
//        MysqlFactory obj = (MysqlFactory) DAOFactory.getDAOFactory();
////        AdminDAO admin = obj.getAdmin();
////        admin.deleteObject(admin);
//        
//        User u = new User();
//        u.setActivated(1); u.setAddress("qqqqqq"); u.setBirthdate(new Date()); u.setEmail("moawad@yahoo.com");
//        u.setPassword("2342432w"); u.setPaypal(324); u.setPermissionId(1); u.setPhone("23423423");
//        u.setUserName("ahmed"); u.setfName("ahmed"); u.setlName("ahmed");
//        UserDAO userDAO = obj.getUser();
//        int insertRows = userDAO.insertObject(u);
//        System.out.println("insertRows : "+ insertRows);
//    }
//    
    public static void main(String[] args) {
//        //get dao from factory
        MysqlFactory obj = (MysqlFactory) DAOFactory.getDAOFactory();
//        
        User u = new User();
        u.setActivated(1); u.setAddress("qqqqqq"); u.setBirthdate(new Date()); u.setEmail("moawad@yahoo.com");
        u.setPassword("2342432w"); u.setPaypal(324); u.setPermissionId(3); u.setPhone("23423423");
        u.setUserName("ahmed"); u.setfName("ahmed"); u.setlName("ahmed");
        UserDAO userDAO = obj.getUser();
        int insertRows = userDAO.insertObject(u);
        System.out.println("insertRows : "+ insertRows);
        
        obj.getUser().insertObject(u);
//        
////        User u = new User();
////        u.setEmail("karim@yahoo.com"); u.setPassword("1234");
////        u = (User) obj.getUser().findObject(u);
////        System.out.println("user name : "+u.getUserName());
//        
////        Permission p = new Permission();
////        p.setName("user");
////        p = (Permission) obj.getPermission().findObject(p);
////        System.out.println("permission name : "+p.getId());
//        
//        Permission p = new Permission();
//        p.setDescription("newUser"); p.setName("newUser");
//        int insertRows = obj.getPermission().insertObject(p);
//        System.out.println("insertRows : "+ insertRows);
        
        
//        User u = new User(); u.setId(10);
//        
//        ArrayList<Bill> bills = (ArrayList<Bill>) obj.getBill().selectObjectsTO(u);
//        for (Bill bill : bills) {
//            System.out.println(""+bill.getId());
//        }
//        
//        ArrayList<Order> orders = (ArrayList<Order>) obj.getOrder().selectObjectsTO(bills.get(1));
//        for (Order order : orders) {
//            System.err.println("Order : "+order.getQuantity());
//        }
    }

}
