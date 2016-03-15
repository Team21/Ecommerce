/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import com.google.gson.Gson;
import com.sun.net.httpserver.HttpServer;
import dao.ProductDAO;

import factory.DAOFactory;
import factory.MysqlFactory;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Product;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public class ProductServlet extends HttpServlet {

    Gson gson = new Gson();
    MysqlFactory factory = (MysqlFactory) DAOFactory.getDAOFactory(DAOFactory.MYSQL);

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String operation = req.getParameter("op");
        if (operation.equals("delete")) {
            deleteProduct(req, resp);
        } else if (operation.equals("add")) {

            addProduct(req, resp);
        } else if (operation.equals("update")) {
            updateProduct(req, resp);
        } else if (operation.equals("getAll")) {
            getProducts(req, resp);
        }
    }

    private void addProduct(HttpServletRequest req, HttpServletResponse resp) {

        ProductDAO productDAO = factory.getProduct();
        String name = req.getParameter("name");
        int quantity = Integer.parseInt(req.getParameter("quntity"));
        String image_url = req.getParameter("imageURL");
        int categoryId = Integer.parseInt(req.getParameter("categoryId"));
        int price = Integer.parseInt(req.getParameter("price"));
        Product product = new Product(name, quantity, image_url, categoryId, price);
        if (productDAO.insertObject(product) > 0) {
            try {
                String toJson = gson.toJson("success");
                resp.getWriter().println(toJson);
            } catch (IOException ex) {
                Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void deleteProduct(HttpServletRequest req, HttpServletResponse resp) {

    }

    private void updateProduct(HttpServletRequest req, HttpServletResponse resp) {
    }

    private void getProducts(HttpServletRequest req, HttpServletResponse resp) {
        ProductDAO productDAO = factory.getProduct();
        productDAO.selectObjectsTO(null);

    }

}
