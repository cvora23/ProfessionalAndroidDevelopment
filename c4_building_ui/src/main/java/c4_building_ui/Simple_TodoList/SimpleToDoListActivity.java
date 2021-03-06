package c4_building_ui.Simple_TodoList;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import cvora.chapter4_building_user_interfaces.R;

public class SimpleToDoListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_to_do_list);

        // Get references to UI widgets
        ListView myListView = (ListView)findViewById(R.id.myListView);
        final EditText myEditText = (EditText)findViewById(R.id.myEditText);

        // Create the Array List of to do items
        final ArrayList<String> todoItems = new ArrayList<String>();
        // Create the Array Adapter to bind the array to the List View
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,todoItems);
        // Bind the Array Adapter to the List View
        if (myListView != null) {
            myListView.setAdapter(aa);
        }
        if (myEditText != null) {
            myEditText.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN)
                        if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                                (keyCode == KeyEvent.KEYCODE_ENTER)) {
                            todoItems.add(0, myEditText.getText().toString());
                            aa.notifyDataSetChanged();
                            myEditText.setText("");
                            return true;
                        }
                    return false;
                }
            });
        }

    }
}
