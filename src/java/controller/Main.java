/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDAO;
import factory.DAOFactory;
import factory.MysqlFactory;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public class Main {

    //example to get dao 
    void foo() {

        //get dao from factory
        MysqlFactory obj = (MysqlFactory) DAOFactory.getDAOFactory(0);
        AdminDAO admin = obj.getAdmin();
        admin.deleteObject(admin);
    }

}
