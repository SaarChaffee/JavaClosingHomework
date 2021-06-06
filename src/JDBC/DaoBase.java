/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/6/5
 */
package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DaoBase {

    public static int Update( String str ) {
        Statement stat = JDBC.getStat();
        int result = 0;
        try{
            result = stat.executeUpdate( str );
            stat.close();
        }catch( SQLException throwable ){
            throwable.printStackTrace();
        }
        return result;
    }

    public static ResultSet Search( String str ) {
        Statement stat = JDBC.getStat();
        ResultSet result = null;
        try{
            result = stat.executeQuery( str );
        }catch( SQLException throwable ){
            throwable.printStackTrace();
        }
        return result;
    }

}

