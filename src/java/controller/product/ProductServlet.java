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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
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

        try {
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();//manage disk factory
            ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);//put it into servletfileuploader
            List<FileItem> items = servletFileUpload.parseRequest(request);//parse request
            Iterator<FileItem> iterator = items.iterator();//iterate on items

            if (iterator.hasNext()) {
                FileItem item = iterator.next();
                String fileName = item.getString();

                if (fileName.equals("add")) {
                    addProduct(request, response, iterator);
                } else if (fileName.equals("edit")) {

                    updateProduct(request, response);
                } else if (fileName.equals("delete")) {

                    deleteProduct(request, response);
                }
            }
        } catch (FileUploadException ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void addProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        FileUploader.fileUploader(request, response);
//
//        ProductDAO productDAO = factory.getProduct();
//        int catId = Integer.parseInt(request.getParameter("catId"));
//        String name = request.getParameter("name");
//        String desc = request.getParameter("desc");
//        int price = Integer.parseInt(request.getParameter("price"));
//        FileUploader.fileUploader(request, response);
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//        Product p = new Product(catId, name, price, quantity, desc);
//        if (productDAO.insertObject(p) > 0) {
//            response.getWriter().write("success");
//        } else {
//            response.getWriter().write("failed");
//        }

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

    private void addProduct(HttpServletRequest req, HttpServletResponse resp, Iterator<FileItem> iterator) {
        try {
            FileItem item = iterator.next();
            item.write(new File(req.getServletContext().getRealPath("/") + "/WEB-INF/img/prod/" + item.getName()));
            int catId = Integer.parseInt(iterator.next().getString());
            int quanity = Integer.parseInt(iterator.next().getString());
            String desc = iterator.next().getString();
            String name = iterator.next().getString();
            int price = Integer.parseInt(iterator.next().getString());
            Product p = new Product(catId, name, price, quanity, desc);
            factory.getProduct().insertObject(p);
        } catch (Exception ex) {
            Logger.getLogger(ProductServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response, Iterator<FileItem> iterator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response, Iterator<FileItem> iterator) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
