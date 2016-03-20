/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.product;

import com.google.gson.Gson;
import controller.file.FileUploader;
import dao.CategoryDAO;
import dao.ProductDAO;
import factory.DAOFactory;
import factory.MysqlFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Category;
import pojo.Product;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */

public class ProductServlet extends HttpServlet {

    private MysqlFactory factory;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        factory = (MysqlFactory) DAOFactory.getDAOFactory();
        gson = new Gson();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        ProductDAO productDAO = factory.getProduct();
        ArrayList<Product> list = (ArrayList<Product>) productDAO.selectObjectsTO(null);
        System.out.println(req.getParameter("op"));
        if (req.getParameter("op") != null) {
            resp.setContentType("application/json");
            resp.getWriter().write(gson.toJson(list));
        } else {
            req.setAttribute("prods", list);
            CategoryDAO categoryDAO = factory.getCategory();
            ArrayList<Category> categories = (ArrayList<Category>) categoryDAO.selectObjectsTO(null);
            req.setAttribute("cats", categories);
            req.getRequestDispatcher("product.jsp").forward(req, resp);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("trace->post product");
        System.out.println(request.getParameter("op"));
        String op = request.getParameter("op");

        if (op.equalsIgnoreCase("add")) {
            addProduct(request, response);
        } else if (op.equalsIgnoreCase("edit")) {
            editProduct(request, response);
        } else if (op.equalsIgnoreCase("update")) {
            updateProduct(request, response);
        } else if (op.equalsIgnoreCase("delete")) {
            deleteProduct(request, response);
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductDAO productDAO = factory.getProduct();
        int catId = Integer.parseInt(request.getParameter("catId"));
        String name = request.getParameter("name");
        String desc = request.getParameter("desc");
        int price = Integer.parseInt(request.getParameter("price"));
        FileUploader.fileUploader(request, response);
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        Product p = new Product(catId, name, price, quantity, desc);
        if (productDAO.insertObject(p) > 0) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("failed");
        }

    }

    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ProductDAO productDAO = factory.getProduct();
        Product p = (Product) productDAO.findObject(new Product(id));
        response.setContentType("Application/json");
        response.getWriter().write(gson.toJson(p));
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ProductDAO productDAO = factory.getProduct();
        int id = Integer.parseInt(request.getParameter("id"));
        Product p = new Product(id);
        if (productDAO.deleteObject(p)) {
            response.getWriter().write("success");

        } else {
            response.getWriter().write("failed");

        }
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ProductDAO productDAO = factory.getProduct();
        int id = Integer.parseInt(request.getParameter("id"));
        int catId = Integer.parseInt(request.getParameter("catId"));
        String name = request.getParameter("name");
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String desc = request.getParameter("desc");
        Product p = new Product(id, catId, name, price, quantity, desc);
        if (productDAO.updateObject(p)) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("failed");

        }

    }

}
