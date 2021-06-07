package JDBC;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
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
    }

    @Test
    public void getLost() {
    }

    @Test
    public void getReport() {
    }
}