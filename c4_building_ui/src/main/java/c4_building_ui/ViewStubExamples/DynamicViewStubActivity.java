package c4_building_ui.ViewStubExamples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;

import cvora.chapter4_building_user_interfaces.R;

public class DynamicViewStubActivity extends AppCompatActivity {

    RelativeLayout r1;
    ViewStub stub;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_view_stub);

        r1 = (RelativeLayout)findViewById(R.id.dynamic_view_stub_id);
        stub = new ViewStub(DynamicViewStubActivity.this);

        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams((int) RelativeLayout.LayoutParams.WRAP_CONTENT,(int)RelativeLayout.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.CENTER_HORIZONTAL);
        params.topMargin = 100;

        stub.setLayoutParams(params);
        r1.addView(stub);

        stub.setLayoutResource(R.layout.subtree);

        View inflated = stub.inflate();
        button = (Button)findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),"View Stub Content Created !!! ",Toast.LENGTH_LONG).show();
            }
        });
    }
}
