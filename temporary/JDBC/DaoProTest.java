package JDBC;

import JDBC.DAO.DaoPro;
import org.junit.Test;

/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2021 2021/6/7
 */
public class DaoProTest {

    @Test
    public void isFriend() {
        System.out.println( DaoPro.isFriend( 0, 53097 ) );
        System.out.println( DaoPro.isFriend( 53097, 686838635 ) );
    }

    @Test
    public void isRedemptionUsed() {
        System.out.println( DaoPro.isRedemptionUsed( "313" ) );
    }

    @Test
    public void recharge() {
        int result = 0;
        int uid = 686838635;
        String code = "yq1308301";
        System.out.println( DaoPro.recharge( uid, code ) );
    }

    @Test
    public void getWin() {
        System.out.println( DaoPro.getWin( 686838635 ) );
    }

    @Test
    public void getLost() {
        System.out.println( DaoPro.getLost( 686838635 ) );
    }

    @Test
    public void getReport() {
        System.out.println( DaoPro.getReport( 686838635 ) );
    }
}