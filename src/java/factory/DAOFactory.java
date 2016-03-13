/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import dao.*;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public abstract class DAOFactory {

    public static final int MYSQL = 0;

    public static DAOFactory getDAOFactory(int type) {
        return new MysqlFactory();
    }
}
