package org.soldiersofthecross.soldadosdelacruz.MaterialNavigationDrawer;


import android.os.Bundle;
import android.app.Fragment;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.soldiersofthecross.soldadosdelacruz.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentIndex extends Fragment {


    public FragmentIndex() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        TextView textView = new TextView(getActivity());
        textView.setText(R.string.hello_blank_fragment);
        textView.setGravity(Gravity.CENTER);
        return textView;
    }


}
