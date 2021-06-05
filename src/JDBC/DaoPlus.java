/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/6/5
 */
package JDBC;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoPlus {
    /**
     * TODO
     * �½��û���
     * �û���¼
     * ��ȡ�û�����
     * �鿴����
     * ��Ӻ���
     * ɾ������
     * �̵꿴����û�еĿ�Ƭ
     * 봽�
     * ��Ƭ����
     * ��ѯ��Ƭ
     * ʤ���������ٱ���ѯ
     *
     */
    public static int getNewUid() {
        return new SecureRandom().nextInt( 999999999 );
    }

    public static int NewUser( String Account, String PassWord, int PhoneNumber ) {
        int result = 0;
        try{
            Connection conn = ( Connection ) JDBC.getStat();
            String str1 = "insert into AccountDate " + "value('?','?','?','?')";
            PreparedStatement pre1 = conn.prepareStatement( str1 );
            pre1.setInt( 1, getNewUid() );
            pre1.setString( 2, Account );
            pre1.setString( 3, PassWord );
            pre1.setInt( 4, PhoneNumber );
            result += pre1.executeUpdate();
            String str2 = "insert into UserData " + "value('?','?','1','0','0','0','0','0',null)";
            PreparedStatement pre2 = conn.prepareStatement( str2 );
            pre2.setInt( 1, getNewUid() );
            pre2.setString( 2, Account );
            result += pre2.executeUpdate();
            String str3 = "insert into CardColle " + "value('?')";
            PreparedStatement pre3 = conn.prepareStatement( str3 );
            pre3.setInt( 1, getNewUid() );
            result += pre3.executeUpdate();
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return result;
    }
}
