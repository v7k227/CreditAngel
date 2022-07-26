package creditangelteam.creditangel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class AccountAngelPage extends AppCompatActivity {
    int Count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_angel_page);

        final Button okbutton = (Button) findViewById(R.id.OkButton2);
        final Button nobutton = (Button) findViewById(R.id.NoButton2);
        final ImageView AngelImgView = (ImageView) findViewById(R.id.AngelImgVIew2);
        final TextView AngelTxtView = (TextView)findViewById(R.id.AngelTxtView2);

        okbutton.setVisibility(View.VISIBLE);
        nobutton.setVisibility(View.VISIBLE);
        okbutton.setText("是");
        nobutton.setText("否");
        AngelImgView.setVisibility(View.VISIBLE);
        AngelTxtView.setVisibility(View.VISIBLE);
        AngelTxtView.setText("是否與好友建立共同聯名帳戶，一起儲存夢想資金呢?");
        Count++;

        okbutton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(Count == 1){
                    nobutton.setVisibility(View.INVISIBLE);
                    okbutton.setText("下一步");
                    AngelTxtView.setText("已發送聯名戶邀請給朋友!");
                }

                if(Count == 2){
                    nobutton.setVisibility(View.INVISIBLE);
                    okbutton.setText("OK");
                    AngelTxtView.setText("您的聯名帳戶已經建立完成!");
                }

                if(Count == 2){
                    AngelTxtView.setText("你已經跨出一大步，完成夢想清單的設定，加油喔!");
                }

                if(Count >=3) {
                    startActivity(new Intent(getApplicationContext(), MainPage.class));
                    finish();
                }
                Count++;
            }
        });

        nobutton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                if(Count == 1){
                    nobutton.setVisibility(View.INVISIBLE);
                    okbutton.setText("OK");
                    AngelTxtView.setText("您未與好友建立聯名帳戶!");
                }

                Count++;
            }
        });
    }
}
