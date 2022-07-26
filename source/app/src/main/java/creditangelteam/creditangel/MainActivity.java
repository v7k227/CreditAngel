package creditangelteam.creditangel;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    private class MainActivityCallback implements HackathonSandboxCallback{
        @Override
        public void callback(HackathonSandboxDef.ActionDef actionDef, JSONObject output) {
            if(actionDef == HackathonSandboxDef.ActionDef.Login){
                try {
                    HackathonSandboxDef.Token = output.getString("Token");
                }
                catch (Exception exc){

                }
            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            MainActivityCallback MAC = new MainActivityCallback();
            HackathonSandbox HS = new HackathonSandbox(HackathonSandboxDef.ActionDef.Login, MAC);
            HS.DoAction();
        }
        catch (Exception e) {
            String Msg = e.getMessage();
        }

        startActivity(new Intent(this, WelcomePage.class));
        finish();
    }
}
