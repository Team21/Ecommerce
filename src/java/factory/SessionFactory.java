/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import static factory.SessionFactory.PRODUCT;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import pojo.Product;
import pojo.User;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public class SessionFactory {

    public static final int ADMIN = 0;
    public static final int USER = 1;
    public static final int PRODUCT = 2;

    public static <T> T getSession(HttpServletRequest req, int type) {
        HttpSession session = req.getSession(false);
        if (type == ADMIN) {
            return (T) session.getAttribute("admin");
        } else if (type == USER) {

            return (T) session.getAttribute("user");
        } else if (type == PRODUCT) {

            return (T) session.getAttribute("product");
        }
        return null;
    }

    public static void setSession(HttpServletRequest req, int type, Object o) {
        HttpSession session = req.getSession(true);

        if (type == ADMIN) {
            session.setAttribute("admin", o);
        }else if(type==USER){
        
            session.setAttribute("user", o);
        }else if(type==PRODUCT){
        
            session.setAttribute("product", o);
        }
    }
}
