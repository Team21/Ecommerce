/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import factory.SessionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.User;

/**
 *
 * @author islam
 */
@WebServlet(name = "profileServlet", urlPatterns = {"/profileServlet"})
public class profileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        System.out.println("in GET Profile Method");
        User user = (User) SessionFactory.getSession(req, SessionFactory.USER);
        System.out.println("email" + user.getEmail());
        RequestDispatcher rd = req.getRequestDispatcher("profilePage.jsp");

//        SessionFactory.setSession(req, SessionFactory.USER, user);

        rd.forward(req, resp);
        //out.println("email"+us.getEmail());

      
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
