package JDBC;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/6/7
 */
public class DaoUltraTest {

    @Test
    public void addFriend() {
        System.out.println( DaoUltra.addFriend( 0, 9497 ) );
    }

    @Test
    public void deleteFriend() {
        System.out.println( DaoUltra.deleteFriend( 0, 9497 ) );
    }

    @Test
    public void userWin() {
    }

    @Test
    public void userLost() {
    }

    @Test
    public void reported() {
    }
}