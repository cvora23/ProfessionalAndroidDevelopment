package c4_building_ui.CustomizedTodoListArrayAdapter;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

import c4_building_ui.FragmentBased_TodoList.NewItemFragment;
import c4_building_ui.FragmentBased_TodoList.TodoListFragment;
import cvora.chapter4_building_user_interfaces.R;

public class TodoListActivity extends AppCompatActivity implements NewItemFragment.OnNewtemAddedListener{

    private TodoItemAdapter arrayAdapter;
    private ArrayList<TodoItem>todoItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo_list);

        FragmentManager fragmentManager = getSupportFragmentManager();
        TodoListFragment todoListFragment = (TodoListFragment)fragmentManager.findFragmentById(R.id.TodoListFragment);

        // Create the array list of to do items
        todoItems = new ArrayList<TodoItem>();
        // Create the array adapter to bind the array to the listview
        int resId = R.layout.todolist_item;
        arrayAdapter = new TodoItemAdapter(this,resId,todoItems);
        // Bind the array adapter to the listview.
        todoListFragment.setListAdapter(arrayAdapter);
    }

    @Override
    public void onNewItemAdded(String newItem) {
        TodoItem todoItem = new TodoItem(newItem);
        todoItems.add(todoItem);
        arrayAdapter.notifyDataSetChanged();
    }
}
