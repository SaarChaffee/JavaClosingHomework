/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/5/27
 */
package JDBC.DAO;

public class DbutilsImplDaoTest {

    public static void main( String[] args ) throws Exception {
        CustomerDao dao = new CustomerDao();

        System.out.println( dao.getUser() );

        System.out.println( dao.update() );

        System.out.println( dao.insert() );

        System.out.println( dao.delete() );

        System.out.println( dao.getValue() );
    }

}
