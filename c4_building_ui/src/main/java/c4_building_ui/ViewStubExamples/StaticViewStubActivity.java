package c4_building_ui.ViewStubExamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.Toast;

import cvora.chapter4_building_user_interfaces.R;

public class StaticViewStubActivity extends AppCompatActivity {

    ViewStub viewStub;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_static_view_stub);

        viewStub = (ViewStub)findViewById(R.id.viewStub1);
        View inflated = viewStub.inflate();

        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"View Stub Content Created !!! ",Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
