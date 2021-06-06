/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/6/5
 */
package JDBC;

import java.security.SecureRandom;
import java.sql.*;

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
        String str = "select * from Friend where UserUid = '" + UserUid + "' UNION ALL select * from Friend where FriendUid = '" + UserUid + "'";
        return DaoBase.Search( str );
    }

    public static int addFriend( int UserUid, int FriendUid ) {
        if( UserUid > FriendUid ){
            UserUid = UserUid ^ FriendUid;
            FriendUid = UserUid ^ FriendUid;
            UserUid = UserUid ^ FriendUid;
        }
        String str = "insert into Friend value('" + UserUid + "','" + FriendUid + "')";
        return DaoBase.Update( str );
    }

    public static boolean isFriend( int UserUid, int FriendUid ) {
        try{
            if( UserUid > FriendUid ){
                UserUid = UserUid ^ FriendUid;
                FriendUid = UserUid ^ FriendUid;
                UserUid = UserUid ^ FriendUid;
            }
            ResultSet re = getFriend( UserUid );
            while( re.next() ){
                if( re.getInt( "FriendUid" ) == FriendUid ) return true;
            }
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return false;
    }

    public static int deleteFriend( int UserUid, int FriendUid ) {
        int result = 0;
        if( UserUid > FriendUid ){
            UserUid = UserUid ^ FriendUid;
            FriendUid = UserUid ^ FriendUid;
            UserUid = UserUid ^ FriendUid;
        }
        if( isFriend( UserUid, FriendUid ) ){
            String str = "delete from Friend where UserUid = '" + UserUid + "' and FriendUid = '" + FriendUid + "'";
            result += DaoBase.Update( str );
            return result;
        }
        return result;
    }

    public static int recharge( int UserUid, String Code ) {
        int result = 0;
        if( !isRedemptionUsed( Code ) ){
            ResultSet re;
            int balance = 0;
            try{
                re = getRedmptionInfo( Code );
                re.next();
                balance = getUserBalance( UserUid ) + re.getInt( "RedemptionCodeValue" );
            }catch( SQLException throwables ){
                throwables.printStackTrace();
            }
            String str1 = "update UserData set UserBalance = '" + balance + "' where UserUid = '" + UserUid + "'";
            result += DaoBase.Update( str1 );
            String str2 = "update Redemption set RedemptionUsed = '" + UserUid + "' where RedemptionCode = '" + Code + "'";
            result += DaoBase.Update( str2 );
        }
        return result;
    }

    public static ResultSet getRedmptionInfo( String RedemptionCode ) {
        String str = "select * from Redemption where RedemptionCode = '" + RedemptionCode + "'";
        return DaoBase.Search( str );
    }

    public static boolean isRedemptionUsed( String RedemptionCode ) {
        try{
            ResultSet re = getRedmptionInfo( RedemptionCode );
            re.next();
            if( re.getInt( "RedemptionUsed" ) != 0 ) return true;
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return false;
    }

    public static int getCard( int UserUid, String CardName ) {
        String str = "update CardColle set " + CardName + " = 'true' where UserUid = '" + UserUid + "'";
        return DaoBase.Update( str );
    }

    public static int userWin( int UserUid ) {
        int win = getWin( UserUid ) + 1;
        String str = "update UserData set UserWin = '" + win + "' where UserUid = '" + UserUid + "'";
        return DaoBase.Update( str );
    }

    public static int userLost( int UserUid ) {
        int lost = getLost( UserUid ) + 1;
        String str = "update UserData set UserLost = '" + lost + "' where UserUid = '" + UserUid + "'";
        return DaoBase.Update( str );
    }

    public static int reported( int UserUid ) {
        int reported = getReport( UserUid ) + 1;
        String str = "update UserData set Reported = '" + reported + "' where UserUid = '" + UserUid + "'";
        return DaoBase.Update( str );
    }

    public static int getWin( int UserUid ) {
        ResultSet re;
        int win = 0;
        try{
            re = getAllUserData( UserUid );
            re.next();
            win = re.getInt( "UserWin" );
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return win;
    }

    public static int getLost( int UserUid ) {
        ResultSet re;
        int lost = 0;
        try{
            re = getAllUserData( UserUid );
            re.next();
            lost = re.getInt( "UserLost" );
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return lost;
    }

    public static int getReport( int UserUid ) {
        ResultSet re;
        int report = 0;
        try{
            re = getAllUserData( UserUid );
            re.next();
            report = re.getInt( "Reported" );
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return report;
    }

    public static boolean[] getColle( int UserUid ) {
        boolean[] colle = new boolean[61];
        try{
            String str = "select * from CardColle where UserUid = '" + UserUid + "'";
            ResultSet re = DaoBase.Search( str );
            re.next();
            for( int i = 1; i <= 60; i++ ){
                colle[i] = re.getBoolean( i );
            }
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return colle;
    }

    public static int getNewUid() {
        return new SecureRandom().nextInt( 999999999 );
    }

    public static int getUserBalance( int UserUid ) {
        ResultSet re;
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
        String str = "select UserUid from AccountDate";
        return DaoBase.Search( str );
    }

    /**
     * TODO
     * SQL防注入攻击
     *
     * @param Account
     * @return
     */
    public static int getUserUidByAcc( String Account ) {
        int result = 0;
        try{
            String str = "select UserUid from AccountDate where UserUid = '" + Account + "'";
            result = DaoBase.Search( str ).getInt( "UserUid" );
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return result;
    }

    public static String getPasswordByAcc( String Account ) {
        String result = null;
        try{
            String str = "select Password from AccountData where Account = '" + Account + "'";
            result = DaoBase.Search( str ).getString( "Password" );
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return result;
    }

    public static ResultSet getAllUserData( int UserUid ) {
        String str = "select * from UserData where UserUid = '" + UserUid + "'";
        return DaoBase.Search( str );
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
