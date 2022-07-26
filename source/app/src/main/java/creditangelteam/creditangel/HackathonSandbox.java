package creditangelteam.creditangel;

import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

interface HackathonSandboxCallback {
    void callback(HackathonSandboxDef.ActionDef actionDef, JSONObject output); // would be in any signature
}

class HackathonSandbox{

    private HackathonSandboxDef.ActionDef actionDef;
    private HackathonSandboxCallback callback;

    public HackathonSandbox(HackathonSandboxDef.ActionDef actionDef, HackathonSandboxCallback callback){
        this.actionDef = actionDef;
        this.callback = callback;
    }

    public void DoAction() throws Exception{

       if(actionDef == HackathonSandboxDef.ActionDef.Login){
           HackathonSandBoxActions HSBA = new HackathonSandBoxActions(actionDef, "login", HackathonSandboxDef.Login_Json(), callback);
           Thread T = new Thread(HSBA);
           T.start();
       }

        if(actionDef == HackathonSandboxDef.ActionDef.CreditCardLimit){
            HackathonSandBoxActions HSBA = new HackathonSandBoxActions(actionDef, "CreditCardLimit", HackathonSandboxDef.CreditCardLimit_Json(), callback);
            Thread T = new Thread(HSBA);
            T.start();
        }

        if(actionDef == HackathonSandboxDef.ActionDef.BonusPointInq){
            HackathonSandBoxActions HSBA = new HackathonSandBoxActions(actionDef, "BonusPointInq", HackathonSandboxDef.CreditCardLimit_BonusPointInq(), callback);
            Thread T = new Thread(HSBA);
            T.start();
        }

    }



}