package edu.utah.further.liteprofiledb.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by andrew on 7/26/16.
 */
@Entity
@Table( name = "users" )
public class UserAuthentication implements Serializable {

    /**
     * The Constant serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     The username.
     **/

    @Id
    @Column (name = "username")
    public String username;

    /** The password. */
    @Column( name = "password" )
    public String password;

    /** The role */
    @Column (name = "role")
    public String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
