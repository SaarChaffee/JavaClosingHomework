/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2021 2021/6/5
 */
package JDBC.DAO;

import java.security.SecureRandom;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * TODO
 * 重新分布Dao层，Domain层
 * 简化DAO层，增加服务层
 * 准备增加WebSocket服务端
 */
public class DaoPlus {
    /**
     * 新建用户
     * 用户登录
     * 读取用户数据
     * 读取收集
     * 查看好友
     * 判断好友
     * 添加好友
     * 删除好友
     * 氪金
     * 查询余额
     * 查询兑换码信息
     * 查询兑换码是否使用
     * 使用兑换码
     * 卡片增加
     * 查询胜场负场举报次数
     * 胜利失败被举报
     */
    public static ResultSet getFriend( int UserUid ) {
        String str = "select FriendUid as friend from Friend where UserUid = " + UserUid + " UNION ALL select UserUid as friend from Friend where FriendUid = " + UserUid;
        return DaoBase.Search( str );
    }

    public static ResultSet getRedemptionInfo( String RedemptionCode ) {
        /**TODO
         * 进一步分离数据
         */
        String str = "select * from Redemption where RedemptionCode = '" + RedemptionCode + "'";
        return DaoBase.Search( str );
    }

    public static int getCard( int UserUid, String CardName ) {
        String str = "update CardColle set " + CardName + " = 'true' where UserUid = '" + UserUid + "'";
        return DaoBase.Update( str );
    }

    public static ResultSet getColleSet( int UserUid ) {
        String str = "select * from CardColle where UserUid = '" + UserUid + "'";
        ResultSet re = DaoBase.Search( str );
        return re;
    }

    public static int getNewUid() {
        return new SecureRandom().nextInt( 999999999 );
    }

    public static int getUserBalance( int UserUid ) {
        ResultSet re = null;
        int balance = 0;
        try{
            re = getAllUserData( UserUid );
            re.next();
            balance = re.getInt( "UserBalance" );
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return balance;
    }

    public static ResultSet getAllUserUid() {
        String str = "select UserUid from AccountData";
        return DaoBase.Search( str );
    }

    public static int getUserUidByTel( String phone ) {
        int result = 0;
        ResultSet re = null;
        try{
            String str = "select UserUid from AccountData where PhoneNumber = '" + phone + "'";
            re = DaoBase.Search( str );
            re.next();
            result = re.getInt( "UserUid" );
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return result;
    }


    public static String getPasswordByTel( String phone ) {
        String result = null;
        Connection conn;
        String str = null;
        ResultSet re = null;
        PreparedStatement pre = null;
        try{
            conn = JDBC.getConn();
            str = "select PassWord from AccountData where PhoneNumber = ?";
            pre = conn.prepareStatement( str );
            pre.setString( 1, phone );
            re = pre.executeQuery();
            re.next();
            result = re.getString( "PassWord" );
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return result;
    }

    public static ResultSet getAllUserData( int UserUid ) {
        /**TODO
         * warning:ResultRet method cant unrecognized data type
         */
        String str = "select * from UserData where UserUid = '" + UserUid + "'";
        return DaoBase.Search( str );
    }

    public static int NewUser( String Account, String PassWord, String PhoneNumber ) {
        /**TODO
         * add uid checking duplicate
         */
        int result = 0;
        int newUid = 0;
        try{
            newUid = getNewUid();
            Connection conn = JDBC.getConn();
            String str1 = "insert into AccountData "
                    + "values(?,?,?,?)";
            PreparedStatement pre1 = conn.prepareStatement( str1 );
            pre1.setInt( 1, newUid );
            pre1.setString( 2, Account );
            pre1.setString( 3, PassWord );
            pre1.setString( 4, PhoneNumber );
            result += pre1.executeUpdate();
            String str2 = "insert into UserData "
                    + "values(?,?,1,0,0,0,0,0,null)";
            PreparedStatement pre2 = conn.prepareStatement( str2 );
            pre2.setInt( 1, newUid );
            pre2.setString( 2, Account );
            result += pre2.executeUpdate();
            String str3 = "insert into CardColle(UserUid) "
                    + "values(?)";
            PreparedStatement pre3 = conn.prepareStatement( str3 );
            pre3.setInt( 1, newUid );
            result += pre3.executeUpdate();
            pre1.close();
            pre2.close();
            pre3.close();
            conn.close();
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return result;
    }
}
