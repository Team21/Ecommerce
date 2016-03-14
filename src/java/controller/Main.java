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
import java.util.Date;
import pojo.Permission;
import pojo.User;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public class Main {

    //example to get dao 
    void foo() {

        //get dao from factory
        MysqlFactory obj = (MysqlFactory) DAOFactory.getDAOFactory(0);
//        AdminDAO admin = obj.getAdmin();
//        admin.deleteObject(admin);
        
        User u = new User();
        u.setActivated(1); u.setAddress("qqqqqq"); u.setBirthdate(new Date()); u.setEmail("moawad@yahoo.com");
        u.setPassword("2342432w"); u.setPaypal(324); u.setPermissionId(1); u.setPhone("23423423");
        u.setUserName("ahmed"); u.setfName("ahmed"); u.setlName("ahmed");
        UserDAO userDAO = obj.getUser();
        int insertRows = userDAO.insertObject(u);
        System.out.println("insertRows : "+ insertRows);
    }
    
    public static void main(String[] args) {
        //get dao from factory
        MysqlFactory obj = (MysqlFactory) DAOFactory.getDAOFactory(0);
        
//        User u = new User();
//        u.setActivated(1); u.setAddress("qqqqqq"); u.setBirthdate(new Date()); u.setEmail("moawad@yahoo.com");
//        u.setPassword("2342432w"); u.setPaypal(324); u.setPermissionId(3); u.setPhone("23423423");
//        u.setUserName("ahmed"); u.setfName("ahmed"); u.setlName("ahmed");
//        UserDAO userDAO = obj.getUser();
//        int insertRows = userDAO.insertObject(u);
//        System.out.println("insertRows : "+ insertRows);
        
//        User u = new User();
//        u.setEmail("karim@yahoo.com"); u.setPassword("1234");
//        u = (User) obj.getUser().findObject(u);
//        System.out.println("user name : "+u.getUserName());
        
//        Permission p = new Permission();
//        p.setName("user");
//        p = (Permission) obj.getPermission().findObject(p);
//        System.out.println("permission name : "+p.getId());
        
        Permission p = new Permission();
        p.setDescription("newUser"); p.setName("newUser");
        int insertRows = obj.getPermission().insertObject(p);
        System.out.println("insertRows : "+ insertRows);
    }

}
