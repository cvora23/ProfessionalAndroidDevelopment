package c4_building_ui.FragmentBased_TodoList;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import cvora.chapter4_building_user_interfaces.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewItemFragment extends Fragment {

    public interface OnNewtemAddedListener{
        public void onNewItemAdded(String newItem);
    }

    private OnNewtemAddedListener onNewtemAddedListener;

    public NewItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_new_item, container, false);
        final EditText myEditText = (EditText)view.findViewById(R.id.myEditText);
        if (myEditText != null) {
            myEditText.setOnKeyListener(new View.OnKeyListener() {
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN)
                        if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER) ||
                                (keyCode == KeyEvent.KEYCODE_ENTER)) {
                            String newItem = myEditText.getText().toString();
                            onNewtemAddedListener.onNewItemAdded(newItem);
                            myEditText.setText("");
                            return true;
                        }
                    return false;
                }
            });
        }
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            onNewtemAddedListener = (OnNewtemAddedListener)context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString() + "must implement OnNewtemAddedListener");
        }

    }
}
