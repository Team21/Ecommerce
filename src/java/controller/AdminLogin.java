/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AdminDAO;
import factory.DAOFactory;
import factory.MysqlFactory;
import factory.Pages;
import factory.SessionFactory;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.Admin;
import pojo.User;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public class AdminLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String passwd = req.getParameter("passwd");
        Admin admin = new Admin(username, passwd);
        MysqlFactory factory = (MysqlFactory) DAOFactory.getDAOFactory(DAOFactory.MYSQL);
        AdminDAO adminDAO = factory.getAdmin();
        admin = (Admin) adminDAO.findObject(admin);
        if (admin != null) {
            SessionFactory.setSession(req, SessionFactory.ADMIN, admin);
            resp.sendRedirect("../adm/home.jsp");
        }
        
    }

}
