/**
 * @Name: JavaClosingHomework
 * @Author: SaarChaffee
 * @Code: UTF-8
 * @Date: Created in 2021 2021/6/9
 */
package JDBC.DOMAIN;

public class RedemptionData {
    String RedemptionCode;
    int RedemptionCodeValue;
    int RedemptionUsed;

    public String getRedemptionCode() {
        return RedemptionCode;
    }

    public void setRedemptionCode( String redemptionCode ) {
        RedemptionCode = redemptionCode;
    }

    public int getRedemptionCodeValue() {
        return RedemptionCodeValue;
    }

    public void setRedemptionCodeValue( int redemptionCodeValue ) {
        RedemptionCodeValue = redemptionCodeValue;
    }

    public int getRedemptionUsed() {
        return RedemptionUsed;
    }

    public void setRedemptionUsed( int redemptionUsed ) {
        RedemptionUsed = redemptionUsed;
    }
}
