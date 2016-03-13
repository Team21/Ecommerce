/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.Collection;
import javax.sql.RowSet;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public interface DAOInter {

    public int insertObject(Object admin);

    public boolean deleteObject(Object admin);

    public Object findObject(Object admin);

    public boolean updateObject(Object admin);

    public RowSet selectObjectsRS(Object admin);

    public Collection selectObjectsTO(Object admin);
}
