/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/5/27
 */
package JDBC.DAO;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Date;

public class User implements Serializable {
    private static final long serialVersionUID = 4131873907877763625L;
    private int id;
    private String userName;
    private String password;
    private Date date;
    private String address;
    private Blob picture;

    public User() {
    }

    public User( int id, String userName, String password, Date date, String address, Blob picture ) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.date = date;
        this.address = address;
        this.picture = picture;
    }

    public User( int id, String userName, String password, Date date, String address ) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.date = date;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {

        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName( String userName ) {
        this.userName = userName;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword( String password ) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate( Date date ) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress( String address ) {
        this.address = address;
    }

    public Blob getPicture() {
        return picture;
    }

    public void setPicture( Blob picture ) {
        this.picture = picture;
    }

    @Override
    public String toString() {
        return "User{" + "userId=" + id + ", userName='" + userName + '\'' + ", password='" + password + '\'' +
                ", date=" + date + ", address='" + address + '\'' + '}';
    }
}
