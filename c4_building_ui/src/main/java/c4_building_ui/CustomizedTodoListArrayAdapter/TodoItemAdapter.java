package c4_building_ui.CustomizedTodoListArrayAdapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cvora.chapter4_building_user_interfaces.R;

/**
 * Created by Admin on 8/1/2016.
 */
public class TodoItemAdapter extends ArrayAdapter<TodoItem> {

    int resource;

    public TodoItemAdapter(Context context, int resource, List<TodoItem> objects) {
        super(context, resource, objects);
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout todoView;
        TodoItem item = getItem(position);

        String taskString = item.getTask();
        Date createdDate = item.getCreated();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.UK);
        String dateString = simpleDateFormat.format(createdDate);

        if(convertView == null){
            todoView = new LinearLayout(getContext());
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater layoutInflater;
            layoutInflater = (LayoutInflater)getContext().getSystemService(inflater);
            layoutInflater.inflate(resource,todoView,true);
        }else {
            todoView = (LinearLayout) convertView;
        }
        TextView dateView = (TextView)todoView.findViewById(R.id.rowDate);
        TextView taskView = (TextView)todoView.findViewById(R.id.row);
        dateView.setText(dateString);
        taskView.setText(taskString);

        return todoView;
    }
}
