/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/6/6
 */
package JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DaoPro {
    public static boolean isFriend( int UserUid, int FriendUid ) {
        try{
            if( UserUid > FriendUid ){
                UserUid = UserUid ^ FriendUid;
                FriendUid = UserUid ^ FriendUid;
                UserUid = UserUid ^ FriendUid;
            }
            ResultSet re = DaoPlus.getFriend( UserUid );
            while( re.next() ){
                if( re.getInt( "FriendUid" ) == FriendUid ) return true;
            }
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return false;
    }



    public static boolean isRedemptionUsed( String RedemptionCode ) {
        try{
            ResultSet re = DaoPlus.getRedmptionInfo( RedemptionCode );
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
                re = DaoPlus.getRedmptionInfo( Code );
                re.next();
                balance = DaoPlus.getUserBalance( UserUid ) + re.getInt( "RedemptionCodeValue" );
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

    public static int getWin( int UserUid ) {
        ResultSet re;
        int win = 0;
        try{
            re = DaoPlus.getAllUserData( UserUid );
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
            re = DaoPlus.getAllUserData( UserUid );
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
            re = DaoPlus.getAllUserData( UserUid );
            re.next();
            report = re.getInt( "Reported" );
        }catch( SQLException throwables ){
            throwables.printStackTrace();
        }
        return report;
    }




}
