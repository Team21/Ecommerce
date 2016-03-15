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

    public int insertObject(Object obj);

    public boolean deleteObject(Object obj);

    public Object findObject(Object obj);

    public boolean updateObject(Object obj);

    public RowSet selectObjectsRS(Object obj);

    public Collection selectObjectsTO(Object obj);
}
