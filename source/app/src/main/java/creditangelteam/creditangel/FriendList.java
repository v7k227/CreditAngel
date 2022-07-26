package creditangelteam.creditangel;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class FriendList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setVisibility(View.GONE);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
            }
        });

        final Button friendBtn1 = (Button) findViewById(R.id.FriendButton1);

        friendBtn1.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                friendBtn1.setText("已加入");
                friendBtn1.setEnabled(false);
            }
        });

        final Button friendBtn2 = (Button) findViewById(R.id.FriendButton2);

        friendBtn2.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                friendBtn2.setText("已加入");
                friendBtn2.setEnabled(false);
            }
        });

        final Button friendBtn3 = (Button) findViewById(R.id.FriendButton3);

        friendBtn3.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                friendBtn3.setText("已加入");
                friendBtn3.setEnabled(false);
            }
        });

        final Button friendBtn4 = (Button) findViewById(R.id.FriendButton4);

        friendBtn4.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                friendBtn4.setText("已加入");
                friendBtn4.setEnabled(false);
            }
        });

        final Button friendBtn5 = (Button) findViewById(R.id.FriendButton5);

        friendBtn5.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                friendBtn5.setText("已加入");
                friendBtn5.setEnabled(false);
            }
        });

        final Button friendBtn6 = (Button) findViewById(R.id.FriendButton6);

        friendBtn6.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                friendBtn6.setText("已加入");
                friendBtn6.setEnabled(false);
            }
        });

        final Button friendBtn7 = (Button) findViewById(R.id.FriendButton7);

        friendBtn7.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                friendBtn7.setText("已加入");
                friendBtn7.setEnabled(false);
            }
        });

        final Button friendBtn8 = (Button) findViewById(R.id.FriendButton8);

        friendBtn8.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                friendBtn8.setText("已加入");
                friendBtn8.setEnabled(false);
            }
        });
    }
}
