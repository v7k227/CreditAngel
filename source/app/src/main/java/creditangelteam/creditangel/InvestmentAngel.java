package creditangelteam.creditangel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class InvestmentAngel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_investment_angel);

        final Button okbutton = (Button) findViewById(R.id.OkButton2);
        final ImageView AngelImgView = (ImageView) findViewById(R.id.AngelImgVIew2);
        final TextView AngelTxtView = (TextView)findViewById(R.id.AngelTxtView2);

        okbutton.setVisibility(View.VISIBLE);
        AngelImgView.setVisibility(View.VISIBLE);
        AngelTxtView.setVisibility(View.VISIBLE);

        okbutton.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                    startActivity(new Intent(getApplicationContext(), WishListPage.class));
                    finish();

            }
        });
    }
}
