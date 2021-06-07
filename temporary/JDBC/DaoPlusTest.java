package JDBC;

import org.junit.Test;

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

    }

    @Test
    public void getPasswordByAcc() {
    }

    @Test
    public void getAllUserData() {
    }

    @Test
    public void newUser() {
        String acc = "313124";
        String passwd = "114514";
        int phone = 1312752271;
        System.out.println( DaoPlus.NewUser( acc, passwd, phone ) );
//        System.out.println( new SecureRandom().nextInt( 999999999 ) );
    }
}