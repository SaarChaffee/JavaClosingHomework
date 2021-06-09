/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2021 2021/6/5
 */
package JDBC.DOMAIN;

import java.sql.ResultSet;

public class UserData {
    int UserUid;
    String UserName;
    String Account;
    String Password;
    String PhoneNumber;
    int UserLevel;
    int UserWin;
    int UserLost;
    int Reported;
    int UserCardQuantity;
    int UserBalance;
    String UserSignature;
    ResultSet FriendUid;
    ResultSet HaveCard;

    public int getUserUid() {
        return UserUid;
    }

    public void setUserUid( int userUid ) {
        UserUid = userUid;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName( String userName ) {
        UserName = userName;
    }

    public String getAccount() {
        return Account;
    }

    public void setAccount( String account ) {
        Account = account;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword( String password ) {
        Password = password;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber( String phoneNumber ) {
        PhoneNumber = phoneNumber;
    }

    public int getUserLevel() {
        return UserLevel;
    }

    public void setUserLevel( int userLevel ) {
        UserLevel = userLevel;
    }

    public int getUserWin() {
        return UserWin;
    }

    public void setUserWin( int userWin ) {
        UserWin = userWin;
    }

    public int getUserLost() {
        return UserLost;
    }

    public void setUserLost( int userLost ) {
        UserLost = userLost;
    }

    public int getReported() {
        return Reported;
    }

    public void setReported( int reported ) {
        Reported = reported;
    }

    public int getUserCardQuantity() {
        return UserCardQuantity;
    }

    public void setUserCardQuantity( int userCardQuantity ) {
        UserCardQuantity = userCardQuantity;
    }

    public int getUserBalance() {
        return UserBalance;
    }

    public void setUserBalance( int userBalance ) {
        UserBalance = userBalance;
    }

    public String getUserSignature() {
        return UserSignature;
    }

    public void setUserSignature( String userSignature ) {
        UserSignature = userSignature;
    }

    public ResultSet getFriendUid() {
        return FriendUid;
    }

    public void setFriendUid( ResultSet friendUid ) {
        FriendUid = friendUid;
    }


    public ResultSet getHaveCard() {
        return HaveCard;
    }

    public void setHaveCard( ResultSet haveCard ) {
        HaveCard = haveCard;
    }
}
