package c4_building_ui.CompassProject_CustomView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cvora.chapter4_building_user_interfaces.R;

public class CompassActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        CustomView customView = (CustomView)findViewById(R.id.compassView);
        customView.setBearing(45);
    }
}
