package JDBC;

import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK 
 * @Date: Created in 2021 2021/6/6
 */public class JDBCTest {

    @Test
    public void getConn() {
        Connection conn = JDBC.getConn();
        try{
            System.out.println(conn.getClientInfo());
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
    }

    @Test
    public void getStat() {
    }
}