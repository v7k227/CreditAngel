package creditangelteam.creditangel;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Sean Wu on 2016/10/1.
 */


public class HackathonSandBoxActions  implements Runnable{

    private HackathonSandboxDef.ActionDef actionDef;
    private String input;
    private HackathonSandboxCallback callback;
    private String webServiceName;

    public HackathonSandBoxActions(HackathonSandboxDef.ActionDef actionDef, String webServiceName, String input, HackathonSandboxCallback callback){
        this.actionDef = actionDef;
        this.webServiceName = webServiceName;
        this.input = input;
        this.callback = callback;
    }

    public JSONObject SendAction(String input) throws Exception
    {
        try
        {
            String WorkUrl = HackathonSandboxDef.TestUrl + webServiceName;
            URL url = new URL(WorkUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-type", "application/json");
            con.setRequestProperty("Content-Length", "" +
                    Integer.toString(input.getBytes().length));
            con.setRequestProperty("Content-Language", "en-US");
            con.setUseCaches (false);
            con.setDoInput(true);
            con.setDoOutput(true);

            //Send request
            DataOutputStream wr = new DataOutputStream (
                    con.getOutputStream ());
            wr.writeBytes (input);
            wr.flush ();
            wr.close ();

            //Get Response
            InputStream is = con.getInputStream();
            BufferedReader rd = new BufferedReader(new InputStreamReader(is));
            String line;
            StringBuffer response = new StringBuffer();
            while((line = rd.readLine()) != null) {
                response.append(line);
            }
            rd.close();

            JSONObject JsonObj = new JSONObject(response.toString());
            return JsonObj;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    public void run() {
        try {
            JSONObject Result = SendAction(input);
            callback.callback(actionDef, Result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
