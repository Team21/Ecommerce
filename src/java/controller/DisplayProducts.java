/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import factory.DAOFactory;
import factory.MysqlFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Product;

/**
 *
 * @author AndDeve
 */
public class DisplayProducts extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("application/json");
        MysqlFactory mysqlFactory = (MysqlFactory) DAOFactory.getDAOFactory();
        ArrayList<Product> products = (ArrayList<Product>) mysqlFactory.getProduct().selectObjectsTO(new Product());
        PrintWriter out = response.getWriter();
        out.println(createJsonObj(products));
    }

    private String createJsonObj(ArrayList<Product> product) {
        Gson gson = new Gson();
        String jsonStr = gson.toJson(product);
        return jsonStr;
    }
}
