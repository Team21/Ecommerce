/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller.category;

import controller.file.FileUploader;
import dao.CategoryDAO;
import factory.DAOFactory;
import factory.MysqlFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Category;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public class CategoryServlet extends HttpServlet {

    private MysqlFactory factory;

    @Override
    public void init() throws ServletException {
        factory = (MysqlFactory) DAOFactory.getDAOFactory();
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

        System.out.println("trace");
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
}
