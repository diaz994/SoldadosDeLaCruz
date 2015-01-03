package org.soldiersofthecross.soldadosdelacruz.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.soldiersofthecross.soldadosdelacruz.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link MesaDeFeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 */
public class MesaDeFeFragment extends Fragment {

    public MesaDeFeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        TextView textView = new TextView(getActivity());
        textView.setText("Mesa De Fe");
        textView.setGravity(Gravity.CENTER);
        return textView;
    }
}
