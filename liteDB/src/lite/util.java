/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2021 2021/6/12
 */
package lite;

import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;

public class util {
    public static ResultSet getFriend( int UserUid ) {
        String str = "select FriendUid as friend from mooer.dbo.Friend where UserUid = " + UserUid + " UNION ALL select UserUid as friend from Friend where FriendUid = " + UserUid;
        return dao.Search( str );
    }

    public static ResultSet getRedemptionInfo( String RedemptionCode ) {
        /**TODO
         * 进一步分离数据
         */
        String str = "select * from mooer.dbo.Redemption where RedemptionCode = '" + RedemptionCode + "'";
        return dao.Search( str );
    }

    public static int getCard( int UserUid, String CardName ) {
        String str = "update mooer.dbo.CardColle set " + CardName + " = 'true' where UserUid = " + UserUid;
        return dao.Update( str );
    }

    public static ResultSet getColleSet( int UserUid ) {
        String str = "select * from mooer.dbo.CardColle where UserUid = " + UserUid;
        ResultSet re = dao.Search( str );
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
        String str = "select UserUid from mooer.dbo.AccountData";
        return dao.Search( str );
    }

    public static int getUserUidByTel( String phone ) {
        int result = 0;
        ResultSet re = null;
        try{
            String str = "select UserUid from mooer.dbo.AccountData where PhoneNumber = '" + phone + "'";
            re = dao.Search( str );
            re.next();
            result = re.getInt( "UserUid" );
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return result;
    }


    public static String getPasswordByTel( String phone ) {
        String result = null;
        String str = null;
        ResultSet re = null;
        try{
            str = "select PassWord from mooer.dbo.AccountData where PhoneNumber = '" + phone + "'";
            re = dao.Search( str );
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
        String str = "select * from mooer.dbo.UserData where UserUid = " + UserUid;
        return dao.Search( str );
    }

    public static int NewUser( String Account, String PassWord, String PhoneNumber ) {
        /**TODO
         * add uid checking duplicate
         */
        int result = 0;
        int newUid = 0;
        newUid = getNewUid();
        String str1 = "insert into mooer.dbo.AccountData "
                + "values(" + newUid + ",'" + Account + "','" + PassWord + "','" + PhoneNumber + "')";
        result += dao.Update( str1 );
        String str2 = "insert into mooer.dbo.UserData "
                + "values(" + newUid + ",'" + Account + "',1,0,0,0,0,0,null)";
        result += dao.Update( str2 );
        String str3 = "insert into mooer.dbo.CardColle(UserUid) "
                + "values(" + newUid + ")";
        result += dao.Update( str3 );
        return result;
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
                if( re.getInt( "friend" ) == FriendUid ) return true;
            }
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return false;
    }


    public static boolean isRedemptionUsed( String RedemptionCode ) {
        try{
            ResultSet re = getRedemptionInfo( RedemptionCode );
            re.next();
            if( re.getInt( "RedemptionUsed" ) != 0 ) return true;
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return false;
    }

    public static int recharge( int UserUid, String Code ) {
        int result = 0;
        if( !isRedemptionUsed( Code ) ){
            ResultSet re;
            int balance = 0;
            try{
                re = getRedemptionInfo( Code );
                re.next();
                balance = getUserBalance( UserUid ) + re.getInt( "RedemptionCodeValue" );
            }catch( SQLException throwables ){
                throwables.printStackTrace();
            }
            String str1 = "update mooer.dbo.UserData set UserBalance = " + balance + " where UserUid = " + UserUid;
            result += dao.Update( str1 );
            String str2 = "update mooer.dbo.Redemption set RedemptionUsed = " + UserUid + " where RedemptionCode = '" + Code + "'";
            result += dao.Update( str2 );
        }
        return result;
    }

    public static boolean[] colles( int UserUid ) {
        ResultSet re = getColleSet( UserUid );
        boolean[] bl = new boolean[61];
        try{
            re.next();
            for( int i = 1; i <= 60; i++ ){
                bl[i] = re.getBoolean( i + 1 );
            }
            re.close();
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return bl;
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

    public static int addFriend( int UserUid, int FriendUid ) {
        int result = 0;
        if( UserUid > FriendUid ){
            UserUid = UserUid ^ FriendUid;
            FriendUid = UserUid ^ FriendUid;
            UserUid = UserUid ^ FriendUid;
        }
        if( !isFriend( UserUid, FriendUid ) ){
            String str = "insert into mooer.dbo.Friend values(" + UserUid + "," + FriendUid + ")";
            result += dao.Update( str );
            return result;
        }
        return result;
    }

    public static int deleteFriend( int UserUid, int FriendUid ) {
        int result = 0;
        if( UserUid > FriendUid ){
            UserUid = UserUid ^ FriendUid;
            FriendUid = UserUid ^ FriendUid;
            UserUid = UserUid ^ FriendUid;
        }
        if( isFriend( UserUid, FriendUid ) ){
            String str = "delete from mooer.dbo.Friend where UserUid = " + UserUid + " and FriendUid = " + FriendUid;
            result += dao.Update( str );
            return result;
        }
        return result;
    }

    public static int userWin( int UserUid ) {
        int win = getWin( UserUid ) + 1;
        String str = "update mooer.dbo.UserData set UserWin = " + win + " where UserUid = " + UserUid;
        return dao.Update( str );
    }

    public static int userLost( int UserUid ) {
        int lost = getLost( UserUid ) + 1;
        String str = "update mooer.dbo.UserData set UserLost = " + lost + " where UserUid = " + UserUid;
        return dao.Update( str );
    }

    public static int reported( int UserUid ) {
        int reported = getReport( UserUid ) + 1;
        String str = "update mooer.dbo.UserData set Reported = " + reported + " where UserUid = " + UserUid;
        return dao.Update( str );
    }
}
