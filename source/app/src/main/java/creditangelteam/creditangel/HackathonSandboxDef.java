package creditangelteam.creditangel;

import org.json.JSONObject;

/**
 * Created by Sean Wu on 2016/10/1.
 */


public class HackathonSandboxDef {
    public static String CustID = "B299629762";
    public static String UserID = "B299629762";
    public static String PIN = "9762";
    public static String AcctNo = "0000495549925705";
    public static String CardNO = "5376751009907889";
    public static String AcctID = "616H-0000154";

    public static String TestUrl = "http://52.69.27.105:8080/hackathon/";

    public static String Token = "";

    public enum ActionDef{
        Login,
        CreditCardLimit,
        BonusPointInq
    }

    public static String Login_Json() throws Exception
    {
        JSONObject jsonParam = new JSONObject();

        jsonParam.put("CustID", CustID);
        jsonParam.put("UserID", UserID);
        jsonParam.put("PIN", PIN);
        jsonParam.put("Token", "token");

        return jsonParam.toString();
    }

    public static String CreditCardLimit_Json() throws Exception
    {
        JSONObject jsonParam = new JSONObject();

        jsonParam.put("CustID", CustID);
        jsonParam.put("Token", Token);

        return jsonParam.toString();
    }

    public static String CreditCardLimit_BonusPointInq() throws Exception
    {
        JSONObject jsonParam = new JSONObject();

        jsonParam.put("CustID", CustID);
        jsonParam.put("Token", Token);

        return jsonParam.toString();
    }
}
