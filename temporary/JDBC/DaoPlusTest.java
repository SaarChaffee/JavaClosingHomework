package JDBC;

import JDBC.DAO.DaoPlus;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2021 2021/6/6
 */
public class DaoPlusTest {

    @Test
    public void getFriend() {
        ResultSet re = DaoPlus.getFriend( 0 );
        try{
            while( re.next() ){
                System.out.println( re.getInt( "friend" ) );
            }
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
    }

    @Test
    public void getRedmptionInfo() {
        ResultSet re = DaoPlus.getRedemptionInfo( "yq1308301" );
        try{
            re.next();
            System.out.println( re.getInt( "RedemptionCodeValue" ) );
            System.out.println( re.getInt( "RedemptionUsed" ) );
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }

    }

    @Test
    public void getCard() {
        String card = "Water1";
        int uid = 686838635;
        System.out.println( DaoPlus.getCard( uid, card ) );
    }

    @Test
    public void getColle() {
        ResultSet colle = null;
        colle = DaoPlus.getColleSet( 686838635 );
        for( int i = 1; i <= 60; i++ ){
            System.out.print( i + ":" );
            System.out.print( colle + " " );
        }
    }

    @Test
    public void getNewUid() {
        System.out.println( DaoPlus.getNewUid() );
    }

    @Test
    public void getUserBalance() {
        System.out.println( DaoPlus.getUserBalance( 686838635 ) );
    }

    @Test
    public void getAllUserUid() {
        ResultSet re = DaoPlus.getAllUserUid();
        try{
            while( re.next() ){

                System.out.println( re.getInt( 1 ) );


            }
            re.close();
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
    }

    @Test
    public void getUserUidByTel() {
        System.out.println( DaoPlus.getUserUidByTel( "99999999999" ) );
    }

    @Test
    public void getPasswordByTel() {
        System.out.println( DaoPlus.getPasswordByTel( "99999999999" ) );
    }

    @Test
    public void getAllUserData() {
        ResultSet re = DaoPlus.getAllUserData( 686838635 );
        try{
            int i = 1;
            re.next();
            System.out.println( re.getInt( "UserBalance" ) );

//            System.out.println( re.getString( 2 ) );
//            System.out.println( re.getBoolean( 2 ) );
            re.close();
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
    }

    @Test
    public void newUser() {
        String acc = "adadadad";
        String passwd = "114514";
        String phone = "99999999999";
        System.out.println( DaoPlus.NewUser( acc, passwd, phone ) );
//        System.out.println( new SecureRandom().nextInt( 999999999 ) );
    }
}