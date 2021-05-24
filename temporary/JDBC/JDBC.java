/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/5/24
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    public static void main( String[] args ) {
        //1.加载驱动
        try{
            Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
            String url = "jdbc:sqlserver://localhost:1433";
            String username = "Java";
            String password = "111";
            Connection conn = null;

//2.获取与数据库的链接
            conn = DriverManager.getConnection( url, username, password );
        }catch( ClassNotFoundException | SQLException e ){
            e.printStackTrace();
        }

    }
}
