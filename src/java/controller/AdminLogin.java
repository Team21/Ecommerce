/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import factory.DAOFactory;
import factory.MysqlFactory;
import factory.SessionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.User;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public class AdminLogin extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User admin = new User(username, password);
        MysqlFactory factory = (MysqlFactory) DAOFactory.getDAOFactory();
        UserDAO adminDAO = factory.getUser();
        Object validUser = adminDAO.findObject(admin);
        if (validUser != null) {
            SessionFactory.setSession(request, SessionFactory.ADMIN, validUser);
            response.getWriter().write("success");
        } else {
            response.getWriter().write("failed");
        }

    }

}
