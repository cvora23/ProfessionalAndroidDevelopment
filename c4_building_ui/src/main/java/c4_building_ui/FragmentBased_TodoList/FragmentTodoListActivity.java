package c4_building_ui.FragmentBased_TodoList;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import cvora.chapter4_building_user_interfaces.R;

public class FragmentTodoListActivity extends AppCompatActivity implements NewItemFragment.OnNewtemAddedListener{

    private ArrayAdapter<String>arrayAdapter;
    private ArrayList<String>todoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_todo_list);

        FragmentManager fragmentManager = getSupportFragmentManager();
        TodoListFragment todoListFragment = (TodoListFragment)fragmentManager.findFragmentById(R.id.TodoListFragment);

        todoItems = new ArrayList<String>();
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,todoItems);
        todoListFragment.setListAdapter(arrayAdapter);

    }

    @Override
    public void onNewItemAdded(String newItem) {
        todoItems.add(newItem);
        arrayAdapter.notifyDataSetChanged();
    }
}
