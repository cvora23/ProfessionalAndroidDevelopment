package c4_building_ui.SimpleTodoListWithCompundView;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import cvora.chapter4_building_user_interfaces.R;

/**
 * Created by Admin on 8/1/2016.
 */
public class ClearableEditText extends LinearLayout {

    private static final String TAG = "ClearableEditText";

    EditText editText;
    Button clearButton;

    public ClearableEditText(Context context) {
        super(context);
        Log.d(TAG,"ClearableEditText");

        // Inflate the view from the layout resource.
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li;
        li = (LayoutInflater) getContext().getSystemService(infService);
        li.inflate(R.layout.clearable_edit_text, this, true);
        // Get references to the child controls.
        editText = (EditText) findViewById(R.id.editText);
        clearButton = (Button) findViewById(R.id.clearButton);
        // Hook up the functionality
        hookupButton();
    }

    public ClearableEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        Log.d(TAG,"ClearableEditText");
    }

    private void hookupButton() {
        clearButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                editText.setText("");
            }
        });
    }
}
