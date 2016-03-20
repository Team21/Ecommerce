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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.Product;

/**
 *
 * @author Hossam
 */
public class DisplyProductDetails extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String productId = request.getParameter("productId");
        System.out.println("DisplyProductDetails : id     "+productId );
        MysqlFactory mysqlFactory = (MysqlFactory) DAOFactory.getDAOFactory();
        Product product = new Product();
        product.setId(Integer.parseInt(productId));
        product = (Product) mysqlFactory.getProduct().findObject(product);
        HttpSession session = request.getSession();
        session.setAttribute("productObj", product);
//        SessionFactory.setSession(request, SessionFactory.PRODUCT, product);
    }
}
