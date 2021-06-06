package JDBC;

import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/6/6
 */
public class DaoBaseTest {

    @Test
    public void update() {
//        String str = "INSERT INTO dbo.AccountData(UserUid,Account,PassWord,PhoneNumber)VALUES(1,1,1,1)";
        String str = "delete from AccountData where UserUid = '1'";
        System.out.println( DaoBase.Update( str ) );
    }

    @Test
    public void search() {
        String str = "select Account from AccountData where PassWord = '1'";
        ResultSet re = DaoBase.Search( str );
        try{
            re.next();
            System.out.println( re.getInt( 1 ) );
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
    }
}