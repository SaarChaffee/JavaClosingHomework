package JDBC;

import JDBC.DAO.DaoUltra;
import org.junit.Test;

/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: UTF-8
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
        System.out.println( DaoUltra.userWin( 686838635 ) );
    }

    @Test
    public void userLost() {
        System.out.println( DaoUltra.userLost( 686838635 ) );
    }

    @Test
    public void reported() {
        System.out.println( DaoUltra.reported( 686838635 ) );
    }
}