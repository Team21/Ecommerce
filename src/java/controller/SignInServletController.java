/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.UserDAO;
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
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/servletsdb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "eslam";
    Connection myConnection = null;
    Statement myStatment = null;
    PreparedStatement insertStatement = null, insertStatement2 = null;

    UserDAO userDao = new UserDAO();
    User registerdUser = new User();

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
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //response.setContentType("application/JSON");
            response.setContentType("text/html");
            System.err.println("in post");
            PrintWriter out = response.getWriter();
            String userEmail, userPassword;
            String dbmail = "", dbpassword = "";

            userEmail = request.getParameter("email");
            userPassword = request.getParameter("password");
            System.out.println("Email :" + userEmail + "\n password : " + userPassword);
            /**
             * *******************************************************************************
             */
            //STEP 4: Execute a query
            System.err.println("Creating statement...");
            String sql = "select * from user where email=? ";
            PreparedStatement preparedStatement = myConnection.prepareStatement(sql);
            preparedStatement.setString(1, userEmail);
            ResultSet result = preparedStatement.executeQuery();
            int i = 0;
            System.out.println("test");

            while (result.next()) {
                dbmail = result.getString("email");
                dbpassword = result.getString("password");
                registerdUser.setId(result.getInt("id"));
                registerdUser.setfName(result.getString("fname"));
                registerdUser.setlName(result.getString("lname"));
                registerdUser.setEmail(result.getString("email"));
                registerdUser.setUserName(result.getString("username"));
                registerdUser.setPassword(result.getString("password"));
                registerdUser.setBirthdate(result.getDate("birthdate"));
                registerdUser.setPaypal(result.getInt("paypal"));
//                Blob blob = result.getBlob("image");
//                int blobLength = (int) blob.length();
//                registerdUser.setImage(blob.getBytes(1, blobLength));

                registerdUser.setPhone(result.getString("phone"));
                registerdUser.setAddress(result.getString("address"));
                registerdUser.setPermissionId(result.getInt("permission_id"));
                registerdUser.setActivated(result.getInt("activated"));

                i++;
            }
            System.out.println("dbamil = " + dbmail + "," + "dbpass = " + dbpassword);
            System.out.println("user :");
            System.out.println(registerdUser.getId());
            System.out.println(registerdUser.getEmail());
            System.out.println(registerdUser.getPassword());
            System.out.println(registerdUser.getPaypal());
            if (userEmail.equals(dbmail) && userPassword.equals(dbpassword)) {
                RequestDispatcher rd = request.getRequestDispatcher("Home.jsp");
                request.setAttribute("user", registerdUser);
                
                
                rd.forward(request, response);
               // System.out.println("request data : "+request.getParameter("email")+request.getParameter("password"));

                out.println(1);//found in database
            } else if (!(userEmail.equals(dbmail) && userPassword.equals(dbpassword))) {

                RequestDispatcher rd = request.getRequestDispatcher("indexHome.jsp");
                rd.forward(request, response);

                out.println(2);//not found in database
            }

        } catch (SQLException ex) {
            Logger.getLogger(SignInServletController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
