/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package searchpkg;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet(name = "searchServlet", urlPatterns = {"/searchServlet"})
public class searchServlet extends HttpServlet {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/servletsdb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "eslam";
    Connection myConnection = null;
    Statement myStatment = null;
    PreparedStatement insertStatement = null, insertStatement2 = null;

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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("in get method");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("application/JSON");
            System.err.println("in post");
            PrintWriter out = response.getWriter();

            String username = request.getParameter("searchValue");
            System.err.println("parameter name = " + username);
            System.err.println(myConnection.toString());

            if (username == "" || username == " " || username == null) {

                out.println(3);
            }
           else if (username != null) {

                //STEP 4: Execute a query
                System.err.println("Creating statement...");

                String sql = "select * from user where username=? ";

                PreparedStatement preparedStatement
                        = myConnection.prepareStatement(sql);

                preparedStatement.setString(1, username);

                ResultSet result = preparedStatement.executeQuery();

                User userObj=  new  User();
                
                System.out.println("execution done of result set  :  " + result.toString());
                String name = "";
                System.err.println("________________________________________________________");
                while (result.next()) {
                    userObj.setId(Integer.parseInt(result.getString("id")));
                    System.out.println("id = " + result.getString("id"));
                    userObj.setfName(result.getString("fname"));
                    System.out.println("first name = " + result.getString("fname"));
                    userObj.setUserName(result.getString("username"));
                    name = result.getString("username");
                    System.out.println("User name = " + result.getString("username"));
                    userObj.setEmail(result.getString("email"));
                    System.out.println("email = " + result.getString("email"));
                }
                System.err.println("________________________________________________________");
                System.err.println("execution done");

                if (name.equalsIgnoreCase(username)) {
                    
                    buildGsonFromUser(userObj);
                    out.println( buildGsonFromUser(userObj)); //found in DB
                } 
               else if (!name.equalsIgnoreCase(username)) {

                    out.println(2); //not found in DB
                }
            }

            // System.err.println(username);
        } catch (SQLException ex) {
            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private String buildGsonFromUser(User user) {
        
        System.out.println("in build json");
        System.out.println("json >>>"+user.getEmail()+user.getfName()+user.getUserName()+user.getId());
        
        Gson gsonuser = new Gson();
        return gsonuser.toJson(user);
    }
}
