/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo;

/**
 *
 * @author Ahmad Moawad <ahmadmoawad3@gmail.com>
 */
public class Admin extends User{

    public Admin() {
    }

    public Admin(String username, String passwd) {
        setUserName(username);
        setPassword(passwd);
    }

    public Admin(String username, String password, String email, String fname, String lname, String imageURL, int permissionId) {
        this(username, password);
        setEmail(email);
        setfName(fname);
        setlName(lname);
        setImageUrl(imageURL);
        addPermissionId(permissionId);
    }
    
}
