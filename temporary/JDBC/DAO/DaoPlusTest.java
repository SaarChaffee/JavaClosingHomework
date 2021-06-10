package JDBC.DAO;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2021 2021/6/10
 */
class DaoPlusTest {

    @Test
    void getUserUidByTel() {
        System.out.println( DaoPlus.getUserUidByTel( "99999999999" ) );
    }

    @Test
    void getPasswordByTel() {
        System.out.println( DaoPlus.getPasswordByTel( "99999999999" ) );
    }

}