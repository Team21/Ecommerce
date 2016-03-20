/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.category;

import com.google.gson.Gson;
import controller.file.FileUploader;
import dao.CategoryDAO;
import factory.DAOFactory;
import factory.MysqlFactory;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pojo.Category;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public class CategoryServlet extends HttpServlet {

    private MysqlFactory factory;
    private Gson gson;

    @Override
    public void init() throws ServletException {
        factory = (MysqlFactory) DAOFactory.getDAOFactory();
        gson = new Gson();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CategoryDAO catDAO = factory.getCategory();
        ArrayList<Category> list = (ArrayList<Category>) catDAO.selectObjectsTO(null);
        req.setAttribute("cats", list);
        System.out.println(req.getParameter("op"));
        if (req.getParameter("op") != null) {
            resp.setContentType("application/json");
            resp.getWriter().write(gson.toJson(list));
        } else {
            req.getRequestDispatcher("category.jsp").forward(req, resp);
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

        String operation = request.getParameter("op");
        if (operation.equalsIgnoreCase("add")) {
            addCat(request, response);
        } else if (operation.equalsIgnoreCase("update")) {
            updateCat(request, response);
        } else if (operation.equalsIgnoreCase("delete")) {
            deleteCat(request, response);
        }
    }

    private void addCat(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        Category category = new Category(name);
//        System.out.println(request.getParameter("img"));
//        FileUploader.fileUploader(request, response);
        CategoryDAO categoryDAO = factory.getCategory();
        if (categoryDAO.insertObject(category) > 0) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("false");
        }

    }

    private void deleteCat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Category category = new Category(id, name);
//        System.out.println(request.getParameter("img"));
//        FileUploader.fileUploader(request, response);
        CategoryDAO categoryDAO = factory.getCategory();
        if (categoryDAO.deleteObject(category)) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("false");
        }
    }

    private void updateCat(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        Category category = new Category(id, name);
//        System.out.println(request.getParameter("img"));
//        FileUploader.fileUploader(request, response);
        CategoryDAO categoryDAO = factory.getCategory();
        if (categoryDAO.updateObject(category)) {
            response.getWriter().write("success");
        } else {
            response.getWriter().write("false");
        }
    }
}
