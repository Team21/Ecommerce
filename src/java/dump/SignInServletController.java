/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dump;

import dao.UserDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.User;

/**
 *
 * @author Hossam
 */
public class SignInServletController extends HttpServlet {

    UserDAO userDao = new UserDAO();
    User registerdUser;

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String userEmail, userPassword;
        userEmail = request.getParameter("email");
        userPassword = request.getParameter("password");
//        System.out.println(userEmail+"  "+userPassword);
        
        registerdUser = (User) userDao.findObject(new User(userEmail, userPassword));
        if(registerdUser!=null){
                System.out.println(registerdUser.getEmail()+registerdUser.getAddress()+registerdUser.getPassword());
//                response.getWriter().write("Welcome.html");
//                response.sendRedirect("Welcome.html");
        }
    }
}
