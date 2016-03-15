//package dump;
//
//import com.google.gson.Gson;
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import pojo.Category;
//import pojo.Product;
//import searchpkg.resultArray;
//import searchpkg.searchServlet;
//import static dump.searchServletProduct.DB_URL;
//
///**
// *
// * @author islam
// */
//@WebServlet(name = "searchServletCategory", urlPatterns = {"/searchServletCategory"})
//public class searchServletCategory extends HttpServlet {
//
//    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
//    static final String DB_URL = "jdbc:mysql://localhost/servletsdb";
//
//    //  Database credentials
//    static final String USER = "root";
//    static final String PASS = "eslam";
//    Connection myConnection = null;
//    Statement myStatment = null;
//    PreparedStatement insertStatement = null, insertStatement2 = null;
//
//    @Override
//    public void init() throws ServletException {
//
//        try {
//            //STEP 2: Register JDBC driver
//            Class.forName("com.mysql.jdbc.Driver");
//
//            //STEP 3: Open a connection
//            System.out.println("Connecting to database...");
//            myConnection = DriverManager.getConnection(DB_URL, USER, PASS);
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        try {
//            response.setContentType("text/html");
//            System.err.println("in post");
//            PrintWriter out = response.getWriter();
//
//            String categoryName = request.getParameter("searchValue");
//            System.err.println("parameter name = " + categoryName);
//            System.err.println(myConnection.toString());
//
//            if (categoryName == "" || categoryName == " " || categoryName == null) {
//
//                out.println(3);
//            } else if (categoryName != null) {
//
//                //STEP 4: Execute a query
//                System.err.println("Creating statement...");
//
//                String sql = "select p.id,p.name,p.category_id,c.id,c.name from product p,category c where p.category_id=c.id and c.name =? ";
//
//                PreparedStatement preparedStatement
//                        = myConnection.prepareStatement(sql);
//
//                preparedStatement.setString(1, categoryName);
//
//                ResultSet result = preparedStatement.executeQuery();
//
//                Product productObj = new Product();
//                Category cobj = new Category();
//
//                System.out.println("execution done of result set  :  " + result.toString());
//
//                String name = "";
//                int i = 0, j = 0;
//                int[] pid = new int[10];
//                int[] pcid = new int[10];
//                int[] cid = new int[10];
//                String[] pname = new String[10];
//                String[] cname = new String[10];
//
//                System.err.println("________________________________________________________");
//                while (result.next()) {
//                    System.out.println(result.getInt(1)
//                            + result.getString(2)
//                            + result.getInt(3)
//                            + result.getInt(4)
//                            + result.getString(5));
//
//                    name = result.getString(5);
//
//                    pid[i] = result.getInt(1);
//                    pname[i] = result.getString(2);
//                    pcid[i] = result.getInt(3);
//                    cid[i] = result.getInt(4);
//                    cname[i] = result.getString(5);
//                    i++;
//                    j++;
//
//                }
//                System.err.println("________________________________________________________");
//                System.err.println("execution done");
//
//                System.out.println(name.equalsIgnoreCase(categoryName));
//
//                if (name.equalsIgnoreCase(categoryName)) {
//                    out.println("productID" + "\t" + "product name" + "\t" + "prod_catg" + "\t" + "category id" + "\t" + "category name");
//
//                    for (i = 0; i < j; i++) {
//                        System.out.println(pid[i] + pname[i] + pcid[i] + cid[i] + cname[i]);
//                        out.println(pid[i] + "\t\t" + pname[i] + "\t\t" + pcid[i] + "\t\t" + cid[i] + "\t" + cname[i]);
//
//                    }
//
//                } else if (!name.equalsIgnoreCase(categoryName)) {
//                    System.out.println("}}} name = " + name);
//                    System.out.println("}}}categoryname = " + categoryName);
//                    out.println(2);
//                    //out.println("Category not found"); //not found in DB
//                }
//            }
//
//            // System.err.println(username);
//        } catch (SQLException ex) {
//            Logger.getLogger(searchServlet.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
//
//    private String buildGsonFromProduct(resultArray rs) {
//
//        System.out.println("in build json");
//        Gson gsonuser = new Gson();
//        return gsonuser.toJson(rs);
//    }
//
//    @Override
//    public String getServletInfo() {
//        return "Short description";
//    }// </editor-fold>
//
//}
