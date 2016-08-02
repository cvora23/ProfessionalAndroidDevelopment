package c4_building_ui.CustomizedTodoListArrayAdapter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Admin on 8/1/2016.
 */
public class TodoItem {

    String task;
    Date created;

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public TodoItem(String task){
        this(task,new Date(java.lang.System.currentTimeMillis()));
    }

    public TodoItem(String task,Date created){
        this.task = task;
        this.created = created;
    }

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yy", Locale.UK);
        String dateString = simpleDateFormat.format(created);
        return "(" + dateString + ")" + task;

    }
}
