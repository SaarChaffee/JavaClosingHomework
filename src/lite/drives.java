/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2021 2021/6/12
 */
package lite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class drives {
    private static Statement stat;

    static {
        //1.加载驱动
        try{
            Class.forName( "com.microsoft.sqlserver.jdbc.SQLServerDriver" );
            String url = "jdbc:sqlserver://localhost:1433";
            String username = "Java";
            String password = "111";
            Connection conn = null;

            //2.获取与数据库的链接
            conn = DriverManager.getConnection( url, username, password );
            stat = conn.createStatement();
        }catch( ClassNotFoundException | SQLException e ){
            e.printStackTrace();
        }

    }

    public static Statement getStat() {
        return stat;
    }
}
