/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: GBK
 * @Date: Created in 2021 2021/6/6
 */
package JDBC;

public class DaoUltra {
    public static int addFriend( int UserUid, int FriendUid ) {
        int result = 0;
        if( UserUid > FriendUid ){
            UserUid = UserUid ^ FriendUid;
            FriendUid = UserUid ^ FriendUid;
            UserUid = UserUid ^ FriendUid;
        }
        if( DaoPro.isFriend( UserUid, FriendUid ) ){
            String str = "insert into Friend values(" + UserUid + "," + FriendUid + ")";
            result += DaoBase.Update( str );
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
        if( DaoPro.isFriend( UserUid, FriendUid ) ){
            String str = "delete from Friend where UserUid = " + UserUid + " and FriendUid = " + FriendUid;
            result += DaoBase.Update( str );
            return result;
        }
        return result;
    }

    public static int userWin( int UserUid ) {
        int win = DaoPro.getWin( UserUid ) + 1;
        String str = "update UserData set UserWin = " + win + " where UserUid = " + UserUid;
        return DaoBase.Update( str );
    }

    public static int userLost( int UserUid ) {
        int lost = DaoPro.getLost( UserUid ) + 1;
        String str = "update UserData set UserLost = " + lost + " where UserUid = " + UserUid;
        return DaoBase.Update( str );
    }

    public static int reported( int UserUid ) {
        int reported = DaoPro.getReport( UserUid ) + 1;
        String str = "update UserData set Reported = " + reported + " where UserUid = " + UserUid;
        return DaoBase.Update( str );
    }
}
