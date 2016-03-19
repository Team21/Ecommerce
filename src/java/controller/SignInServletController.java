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
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.User;
import searchpkg.searchServlet;

/**
 *
 * @author Hossam
 */
@WebServlet(name = "SignInServletController", urlPatterns = {"/SignInServletController"})
public class SignInServletController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //response.setContentType("application/JSON");
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String userEmail, userPassword;

        userEmail = request.getParameter("email");
        userPassword = request.getParameter("password");
        User u = new User();
        u.setEmail(userEmail);
        u.setPassword(userPassword);

        MysqlFactory mysqlFactory = (MysqlFactory) DAOFactory.getDAOFactory();
        User userObj = (User) mysqlFactory.getUser().findObject(u);

        if (userObj != null) {
            RequestDispatcher rd = request.getRequestDispatcher("displaylist.jsp");
            SessionFactory.setSession(request, SessionFactory.USER, userObj);
            rd.forward(request, response);
            out.println("found in database : "+1);//found in database
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("indexHome.jsp");
            rd.forward(request, response);
            out.println("not found in database : "+2);//not found in database
        }

    }
}
