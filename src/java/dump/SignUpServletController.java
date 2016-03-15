/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dump;

import dao.UserDAO;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.User;

/**
 *
 * @author Hossam
 */
public class SignUpServletController extends HttpServlet {

    UserDAO userDao = new UserDAO();
    User newUser;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userEmail, userFirstName, userLastName, username, userPassword, userAddress, userPhone, userBirthdate;
        Date birthDate = null;
        int userPaypal;
        boolean flag;
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");

        userEmail = request.getParameter("email");
        userFirstName = request.getParameter("fname");
        userLastName = request.getParameter("lName");
        username = request.getParameter("username");
        userPassword = request.getParameter("password");
        userPhone = request.getParameter("phone");
        userAddress = request.getParameter("address");
        userPaypal = Integer.parseInt(request.getParameter("paypal"));
//        userBirthdate = request.getParameter("Birthdate");
//        try {
//            birthDate = formatter.parse(userBirthdate);
//        } catch (ParseException ex) {
//            Logger.getLogger(SignUpServletController.class.getName()).log(Level.SEVERE, null, ex);
//        }

        System.out.println(userAddress + userEmail + userFirstName + userLastName + userPassword + userPhone + username);
        System.out.println("check obj" + newUser.toString());
        newUser.setAddress(userAddress);
        newUser.setBirthdate(birthDate);
        newUser.setEmail(userEmail);
        newUser.setPassword(userPassword);
        newUser.setPaypal(userPaypal);
        newUser.setPhone(userPhone);
        newUser.setUserName(username);
        newUser.setfName(userFirstName);
        newUser.setlName(userLastName);

        if (userDao.insertObject(new User(newUser, userPassword)) > 0) {
            System.out.println("nice");
        }
    }
}
