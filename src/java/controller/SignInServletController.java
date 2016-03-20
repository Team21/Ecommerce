/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import factory.DAOFactory;
import factory.MysqlFactory;
import factory.SessionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.Category;
import pojo.Product;
import pojo.User;

/**
 *
 * @author Hossam
 */
@WebServlet(name = "SignInServletController", urlPatterns = {"/SignInServletController"})
public class SignInServletController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        User u = new User();
        u.setEmail(request.getParameter("email"));
        u.setPassword(request.getParameter("password"));

        MysqlFactory mysqlFactory = (MysqlFactory) DAOFactory.getDAOFactory();
        User userObj = (User) mysqlFactory.getUser().findObject(u);

        if (userObj != null) {
            
            RequestDispatcher rd = request.getRequestDispatcher("displaylist.jsp");
            SessionFactory.setSession(request, SessionFactory.USER, userObj);
            boolean cbRememberme = request.getParameter("RememberMe") != null;
            if (cbRememberme) {
                Cookie cookieUser = new Cookie("cookieUser", userObj.getUserName());
                cookieUser.setMaxAge(60 * 24 * 7);
                response.addCookie(cookieUser);
                Cookie cookiePassword = new Cookie("cookiePassword", userObj.getPassword());
                cookiePassword.setMaxAge(60 * 24 * 7);
                response.addCookie(cookiePassword);
                System.out.println("cookie : ");
            }
            HttpSession session = request.getSession(true);
            putObjectsonSession(request,session);
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("indexHome.jsp");

            rd.forward(request, response);
        }
    }

    public void putObjectsonSession(HttpServletRequest request,HttpSession session) {
        // to get all product 
        MysqlFactory mysqlFactory = (MysqlFactory) DAOFactory.getDAOFactory();
        ArrayList<Product> products = (ArrayList<Product>) mysqlFactory.getProduct().selectObjectsTO(new Product());

        ArrayList<Category> categorys = (ArrayList<Category>) mysqlFactory.getCategory().selectObjectsTO(new Category());

        session.setAttribute("products", products);
        session.setAttribute("categorys", categorys);
    }
}
