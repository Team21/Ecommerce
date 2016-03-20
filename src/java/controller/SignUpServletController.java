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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(name = "SignUpServletController", urlPatterns = {"/SignUpServletController"})
public class SignUpServletController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    
    private java.sql.Date convertDate(String birthday){
        System.out.println("birthdate before formate = " + birthday);
        Date be = new Date();
        System.out.println(be.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            be = formatter.parse(birthday);
        } catch (ParseException ex) {
            Logger.getLogger(SignUpServletController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("date after format dddd= " + be);
        return new java.sql.Date(be.getTime());
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        
        String paypal = request.getParameter("inputPayPal");
        String imageurl = request.getParameter("pic");
        String birthdate = request.getParameter("Days") + "-" + request.getParameter("Months") + "-" + request.getParameter("Years");
        // String testDate = "29-Apr-2010,13:00:14 PM";
        
        java.sql.Date sqlDate = convertDate(birthdate);
        User u = new User();
        u.setfName(request.getParameter("inputFname1"));
        u.setlName(request.getParameter("inputLname1"));
        u.setUserName(request.getParameter("inputUserName"));
        u.setEmail(request.getParameter("inputEmail"));
        u.setAddress(request.getParameter("inputAddress"));
        u.setPassword(request.getParameter("inputPassword"));
        //u.setBirthdate(sqlDate); //u.setImage(image);
        u.setPaypal(Integer.parseInt(paypal));
        u.setPermissionId(3); u.setActivated(1);
        u.setPhone(request.getParameter("inputPhone"));   
        
        
        
        MysqlFactory mysqlFactory = (MysqlFactory) DAOFactory.getDAOFactory();
        // if email is already Existed 
        // so email is invalid
        if(mysqlFactory.getUser().getUserID(u.getEmail()) == 0) {
            // insert Object User in DB
            mysqlFactory.getUser().insertObject(u);
            // Get User Id 
            u.setId(mysqlFactory.getUser().getUserID(u.getEmail()));

            System.out.println("user id = " + u.getId());
            SessionFactory.setSession(request, SessionFactory.USER, u);

            HttpSession session = request.getSession(true);
            putObjectsonSession(request,session);
            RequestDispatcher rd = request.getRequestDispatcher("displaylist.jsp");
            rd.forward(request, response);
        }
        else {
            HttpSession session = request.getSession();
            session.setAttribute("invalidEmail", "Email already used before");
            RequestDispatcher rd = request.getRequestDispatcher("indexHome.jsp");
            rd.forward(request, response);
        }
    }
    
    private void putObjectsonSession(HttpServletRequest request,HttpSession session) {
        // to get all product 
        MysqlFactory mysqlFactory = (MysqlFactory) DAOFactory.getDAOFactory();
        ArrayList<Product> products = (ArrayList<Product>) mysqlFactory.getProduct().selectObjectsTO(new Product());

        ArrayList<Category> categorys = (ArrayList<Category>) mysqlFactory.getCategory().selectObjectsTO(new Category());

        session.setAttribute("products", products);
        session.setAttribute("categorys", categorys);
    }
}
