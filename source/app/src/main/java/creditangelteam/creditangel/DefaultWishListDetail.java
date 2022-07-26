package creditangelteam.creditangel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class DefaultWishListDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_default_wish_list_detail);

        Button FriendBtn = (Button)findViewById(R.id.FriendButton);

        FriendBtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), FriendList.class));
            }
        });

        final Button OKBtn = (Button)findViewById(R.id.currentButton);

        OKBtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AccountAngelPage.class));
            }
        });
    }
}
