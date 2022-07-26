package creditangelteam.creditangel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class PersonalWishListSetting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_wish_list_setting);

        ImageButton PersonalimageBtn = (ImageButton)findViewById(R.id.PersonalimageButton);

        PersonalimageBtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), EditPersonalWishListSetting.class));
            }
        });

        ImageButton DefaultImagebtn = (ImageButton)findViewById(R.id.DefaultImageButton);

        DefaultImagebtn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), DefaultEditWishList.class));
            }
        });
    }
}
