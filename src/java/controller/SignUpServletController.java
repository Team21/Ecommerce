/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
import database.DBConnectionHandler;
import factory.MysqlFactory;
import factory.SessionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@WebServlet(name = "SignUpServletController", urlPatterns = {"/SignUpServletController"})
public class SignUpServletController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/servletsdb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "null";
    Connection myConnection = null;
    Statement myStatment = null;
    PreparedStatement insertStatement = null, insertStatement2 = null;
    UserDAO userDao = new UserDAO();
    User newUser;
    int userID = 0;

    @Override
    public void init() throws ServletException {

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            myConnection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        System.err.println("in post");
        PrintWriter out = response.getWriter();

        String username = request.getParameter("inputUserName");
        // System.out.println("user men el saf7a = " + username);
        String password = request.getParameter("inputPassword");
        String fname = request.getParameter("inputFname1");
        String lname = request.getParameter("inputLname1");
        String email = request.getParameter("inputEmail");
        String paypal = request.getParameter("inputPayPal");
        String phone = request.getParameter("inputPhone");
        String address = request.getParameter("inputAddress");
        String imageurl = request.getParameter("pic");
        String birthdate = request.getParameter("Days") + "-" + request.getParameter("Months") + "-" + request.getParameter("Years");
        // String testDate = "29-Apr-2010,13:00:14 PM";
        System.out.println("birthdate before formate = " + birthdate);
        Date be = new Date();
        System.out.println(be.getTime());
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        try {
            be = formatter.parse(birthdate);

        } catch (ParseException ex) {
            Logger.getLogger(SignUpServletController.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("date after format dddd= " + be);
        //System.out.println(date);
        try {
//            myConnection = DBConnectionHandler.getInstance().getConnection();
//            System.out.println("my connection = " + myConnection.toString());
            // System.out.println("schema db = "+myConnection.getSchema()+myConnection.getCatalog());
            insertStatement = myConnection.prepareStatement("insert into user (fname,lname,email,username,password,birthdate,paypal,phone,address,permission_id,activated) values(?,?,?,?,?,?,?,?,?,3,1)");
            insertStatement.setString(1, fname);
            insertStatement.setString(2, lname);
            insertStatement.setString(3, email);
            insertStatement.setString(4, username);

            insertStatement.setString(5, password);
            java.sql.Date sqlDate = new java.sql.Date(be.getTime());
            insertStatement.setDate(6, sqlDate);

            insertStatement.setInt(7, Integer.parseInt(paypal));
            insertStatement.setString(8, phone);
            insertStatement.setString(9, address);

            insertStatement.executeUpdate();
            // myConnection.commit();

        } catch (SQLException ex) {
            Logger.getLogger(SignUpServletController.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            insertStatement2 = myConnection.prepareStatement("select id from user where email=?");
            insertStatement2.setString(1, email);
            
            ResultSet rs = insertStatement2.executeQuery();
            while (rs.next()) {
                userID = rs.getInt("id");
            }

        } catch (SQLException ex) {
            Logger.getLogger(SignUpServletController.class.getName()).log(Level.SEVERE, null, ex);
        }

        System.out.println("user id = "+userID);
        
        newUser = new User();
        newUser.setId(userID);
        newUser.setfName(fname);
        newUser.setlName(lname);
        newUser.setEmail(email);
        newUser.setUserName(username);
        newUser.setPassword(password);
        newUser.setBirthdate(be);
        newUser.setPaypal(Integer.parseInt(paypal));
        //newUser.setImage(image);
        newUser.setPhone(phone);
        newUser.setAddress(address);
        
        
        
        
        
        
        
          RequestDispatcher rd = request.getRequestDispatcher("displaylist.jsp");
//                request.setAttribute("user", newUser);
                SessionFactory.setSession(request, SessionFactory.USER, newUser);
                
                
                rd.forward(request, response);
//        out.println("regitered user :<br/><br/>" + "username : " + username + "<br/>"
//                + "Password : " + password
//                + "<br/>first name : " + fname
//                + "<br/>last name : " + lname
//                + "<br/>email : " + email
//                + "<br/>paypal credit = " + paypal + "<br/>phone : " + phone + "<br/>address : " + address + "<br/>image url = "
//                + imageurl + "<br/>Birth date : " + birthdate);

    }
}
