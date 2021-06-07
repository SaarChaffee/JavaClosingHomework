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
public class DaoPlusTest {

    @Test
    public void getFriend() {
    }

    @Test
    public void getRedmptionInfo() {
    }

    @Test
    public void getCard() {
    }

    @Test
    public void getColle() {
    }

    @Test
    public void getNewUid() {
    }

    @Test
    public void getUserBalance() {
    }

    @Test
    public void getAllUserUid() {
    }

    @Test
    public void getUserUidByAcc() {
        System.out.println(DaoPlus.getUserUidByAcc( "adadadad" ));
    }

    @Test
    public void getPasswordByAcc() {
        System.out.println( DaoPlus.getPasswordByAcc( "adadadad" ) );
    }

    @Test
    public void getAllUserData() {
        ResultSet re = DaoPlus.getAllUserData( 686838635 );
        try{
            int i = 1;
            re.next();
            System.out.println( re.getInt( i++ ) );

            System.out.println( re.getString( 2 ) );
            System.out.println( re.getBoolean( 2 ) );
            re.close();
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
    }

    @Test
    public void newUser() {
        String acc = "adadadad";
        String passwd = "114514";
        int phone = 13332271;
        System.out.println( DaoPlus.NewUser( acc, passwd, phone ) );
//        System.out.println( new SecureRandom().nextInt( 999999999 ) );
    }
}