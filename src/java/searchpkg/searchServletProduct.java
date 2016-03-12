package searchpkg;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pojo.Category;
import pojo.Product;
import pojo.User;
import static searchpkg.searchServlet.DB_URL;

/**
 *
 * @author islam
 */
@WebServlet(name = "searchServletProduct", urlPatterns = {"/searchServletProduct"})
public class searchServletProduct extends HttpServlet {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/servletsdb";

    //  Database credentials
    static final String USER = "root";
    static final String PASS = "eslam";
    Connection myConnection = null;
    Statement myStatment = null;
    PreparedStatement insertStatement = null, insertStatement2 = null;

    @Override
    public void init() throws ServletException {
        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            myConnection = DriverManager.getConnection(DB_URL, USER, PASS);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            response.setContentType("application/JSON");
            System.err.println("in post");
            PrintWriter out = response.getWriter();

            String productName = request.getParameter("searchValue");
            System.err.println("parameter name = " + productName);
            System.err.println(myConnection.toString());

            if (productName == "" || productName == " " || productName == null) {

                out.println(3);
            } else if (productName != null) {

                //STEP 4: Execute a query
                System.err.println("Creating statement...");

                String sql = "select p.*,c.name from product p,category c where p.name =? and p.id = c.id   ";

                PreparedStatement preparedStatement
                        = myConnection.prepareStatement(sql);

                preparedStatement.setString(1, productName);

                ResultSet result = preparedStatement.executeQuery();

                Product productObj = new Product();
                Category cobj = new Category();

                System.out.println("execution done of result set  :  " + result.toString());
                String name = "";
                System.err.println("________________________________________________________");
                while (result.next()) {
                    productObj.setId(Integer.parseInt(result.getString("id")));
                    System.out.println("product id = " + result.getString("id"));
                    productObj.setName(result.getString("name"));
                    name = result.getString("name");
                    System.out.println("product name = " + result.getString("name"));
                    productObj.setPrice(result.getInt("price"));
                    System.out.println("product price = " + result.getInt("price"));
                    productObj.setQuantity(result.getInt("quantity"));
                    System.out.println("product Quantity = " + result.getInt("quantity"));
                    productObj.setCategoryId(result.getInt("category_id"));
                    System.out.println("product category_id = " + result.getInt("category_id"));

                    cobj.setName(result.getString(7));
                    System.out.println(">>>>>>>>>>>categoty name = " + cobj.getName());

                }
                System.err.println("________________________________________________________");
                System.err.println("execution done");

                if (name.equalsIgnoreCase(productName)) {

                    buildGsonFromProduct(productObj);
                    out.println(buildGsonFromProduct(productObj) ); //found in DB
                } else if (!name.equalsIgnoreCase(productName)) {

                    out.println(2); //not found in DB
                }
            }

            // System.err.println(username);
        } catch (SQLException ex) {
            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private String buildGsonFromProduct(Product product) {

        System.out.println("in build json");
        System.out.println("json >>>" + product.getId() + product.getName() + product.getPrice() + product.getQuantity() + product.getCategoryId());

        Gson gsonuser = new Gson();
        return gsonuser.toJson(product);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
