/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import factory.SessionFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

/**
 *
 * @author islam
 */
@WebServlet(name = "EditProfileServlet", urlPatterns = {"/EditProfileServlet"})
public class EditProfileServlet extends HttpServlet {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/servletsdb";
    private static String uname = "";//example xxxx.xxx@xx.com
    private static String passwd = "";
    //  Database credentials
    static final String USER = "root";
    static final String PASS = "root";
    Connection myConnection = null;
    Statement myStatment = null;
    PreparedStatement insertStatement = null, insertStatement2 = null;

    User updatedUser = new User();

    @Override
    public void init() throws ServletException {
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            myConnection = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            myStatment = myConnection.createStatement();

//            String sqlcount = "select * from userlogin ";
//            ResultSet rsc = myStatment.executeQuery(sqlcount);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("application/JSON");
            PrintWriter out = response.getWriter();

            String fname = request.getParameter("fanme");
            String lname = request.getParameter("lname");
            String email = request.getParameter("email");
            String username = request.getParameter("userName");
            String password = request.getParameter("password");
            String birthDate = request.getParameter("Birthdate");
            String paypal = request.getParameter("paypal");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            System.out.println("date gay men el user string = " + birthDate);
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date parsed = format.parse(birthDate);
            System.out.println("ba3d el ta7weel lel java.util.date = " + parsed);
            java.sql.Date sql = new java.sql.Date(parsed.getTime());
            System.out.println("ba3d el ta7weel lel sql date = " + sql);

            String sqlQuery = "update user set fname=?,lname=?,email=?,username=?,password=?,birthdate=?,paypal=?,phone=?,address=? where email=? ";
            insertStatement = myConnection.prepareStatement(sqlQuery);
            /*Updateable Data*/
            insertStatement.setString(1, fname);
            insertStatement.setString(2, lname);
            insertStatement.setString(3, email);
            insertStatement.setString(4, username);
            insertStatement.setString(5, password);
            insertStatement.setDate(6, sql);
            insertStatement.setInt(7, Integer.parseInt(paypal));
            insertStatement.setString(8, phone);
            insertStatement.setString(9, address);
            /*Where Condition*/
            insertStatement.setString(10, email);
            insertStatement.executeUpdate();

            updatedUser.setfName(fname);
            updatedUser.setlName(lname);
            updatedUser.setEmail(email);
            updatedUser.setUserName(username);
            updatedUser.setPassword(password);
            updatedUser.setPaypal(Integer.parseInt(paypal));
            updatedUser.setBirthdate(parsed);
            updatedUser.setPhone(phone);
            updatedUser.setAddress(address);

            String jsonObj = buildGsonFromObj(updatedUser);
            System.out.println("user Updated in DB and changed to JSON Object");

            out.println(jsonObj);//dah kdah mesh hayreflect 3ashan
            //ana 3amalt forwared lel request wel response

            //User user = (User) SessionFactory.getSession(request, SessionFactory.USER);
            RequestDispatcher rd = request.getRequestDispatcher("profilePage.jsp");
            SessionFactory.setSession(request, SessionFactory.USER, updatedUser);
            rd.forward(request, response);

        } catch (SQLException | ParseException ex) {
            Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String buildGsonFromObj(User user) {
        Gson gsonuser = new Gson();
        return gsonuser.toJson(user);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
