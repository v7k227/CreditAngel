package creditangelteam.creditangel;

import android.content.Intent;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

//import com.getbase.floatingactionbutton.FloatingActionButton;


public class FloatBtnPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_float_btn_page);

        final View actionB = findViewById(R.id.action_b);
        final View actionD = findViewById(R.id.action_c);


        actionB.setEnabled(false);
        actionD.setEnabled(false);

        //final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        //menuMultipleActions.addButton(actionC);

        ShapeDrawable drawable = new ShapeDrawable(new OvalShape());
        drawable.getPaint().setColor(getResources().getColor(R.color.white));

        final com.getbase.floatingactionbutton.FloatingActionButton actionA = (com.getbase.floatingactionbutton.FloatingActionButton) findViewById(R.id.action_a);
        actionA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),InvestmentListPage.class));
            }
        });
    }
}
