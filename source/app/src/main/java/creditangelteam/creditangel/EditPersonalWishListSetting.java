package creditangelteam.creditangel;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditPersonalWishListSetting extends AppCompatActivity {
    static int Count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_personal_wish_list_setting);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        //.setAction("Action", null).show();
            }
        });

        final Button OKBtn = (Button)findViewById(R.id.currentButton);

        EditText dreamNameEditText = (EditText)findViewById(R.id.DreamNameEditText);
        dreamNameEditText.setText("出國留學", TextView.BufferType.EDITABLE);

        EditText timeEditText = (EditText)findViewById(R.id.TimeEditText);
        timeEditText.setText("2017/5/20", TextView.BufferType.EDITABLE);

        EditText moneyEditText = (EditText)findViewById(R.id.MoneyEditText);
        moneyEditText.setText("1,000,000", TextView.BufferType.EDITABLE);

        EditText pSEditText = (EditText)findViewById(R.id.PSEditText);
        pSEditText.setText("一起存下美國留學資金, 別留下遺憾的人生 Fight!", TextView.BufferType.EDITABLE);

        OKBtn.setOnClickListener(new Button.OnClickListener(){
            @Override
            public void onClick(View v) {

                try {
                    EditText moneyEditText = (EditText) findViewById(R.id.MoneyEditText);
                    String str = moneyEditText.getText().toString();
                    str = str.replaceAll(",", "");

                    int intValue = Integer.parseInt(str);

                    if (intValue > 5000000) {
                        AlertDialog.Builder MyAlertDialog = new AlertDialog.Builder(EditPersonalWishListSetting.this);

                        MyAlertDialog.setTitle("超出平均月薪所承受範圍");

                        MyAlertDialog.setMessage("建議改變儲蓄金額");

                        MyAlertDialog.show();
                    } else {
                        startActivity(new Intent(getApplicationContext(), AccountAngelPage.class));
                    }
                }
                catch (Exception e)
                {
                    startActivity(new Intent(getApplicationContext(), AccountAngelPage.class));
                }


            }
        });
    }

}
