/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import factory.DAOFactory;
import factory.MysqlFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Product;

/**
 *
 * @author Hossam
 */
public class RequestReciever extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String productId = request.getParameter("productId");
        MysqlFactory mysqlFactory = (MysqlFactory) DAOFactory.getDAOFactory();
        Product product = new Product();
        product.setId(Integer.parseInt(productId));
        product = (Product) mysqlFactory.getProduct().findObject(product);
        System.out.println("Name:     "+product.getName());
    }
    
}
