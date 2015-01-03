package org.soldiersofthecross.soldadosdelacruz.fragments;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.artifex.mupdfdemo.MuPDFActivity;
import com.artifex.mupdfdemo.MuPDFCore;
import com.artifex.mupdfdemo.MuPDFPageAdapter;
import com.artifex.mupdfdemo.MuPDFReaderView;
import com.artifex.mupdfdemo.SearchTask;

import org.soldiersofthecross.soldadosdelacruz.Constants;
import org.soldiersofthecross.soldadosdelacruz.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EscuelaSabaticaFragment extends Fragment {

    private RelativeLayout escuelaSabaticaLayout;
    private MuPDFCore pdfCore;
    private MuPDFReaderView pdfReaderView;
    private Context mContext;
    private SearchTask searchTask;
    Bundle arguments = new Bundle();
    private String mFilepath;
    final private static String TAG = "EscuelaSabaticaFragment";

    public EscuelaSabaticaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // getting the current activity
        mContext = getActivity();

        // inflating the escuela sabatica view
        View escuelaSabaticaView = inflater.inflate(R.layout.fragment_escuela_sabatica, container, false);

        escuelaSabaticaLayout = (RelativeLayout) escuelaSabaticaView.findViewById(R.id.pdflayout);

        pdfCore = openPdfFile(Uri.decode(Constants.pathToPdf));

        if(pdfCore != null) {
            pdfReaderView = new MuPDFReaderView(getActivity()) {
                @Override
                protected void onMoveToChild(int i) {
                    if(pdfCore == null) {
                        super.onMoveToChild(i);
                    }
                }
            };

            pdfReaderView.setAdapter(new MuPDFPageAdapter(mContext, pdfCore));
            escuelaSabaticaLayout.addView(pdfReaderView);
        }


        return escuelaSabaticaView;

    }

    private MuPDFCore openPdfFile(String path) {
        Log.d(TAG, "In openPdfFile with path: " + path);

        try {
            pdfCore = new MuPDFCore(mContext, path);
        } catch(Exception exception) {
            Log.e(TAG, exception.getMessage() + " returning null");
            return null;
        }

        Log.d(TAG, "No exceptions in open Pdf File.");
        Log.d(TAG, "MuPdfCore object created successfully");
        return pdfCore;
    }

    private MuPDFCore openBuffer(byte buffer[]) {
        System.out.println("Trying to open byte buffer");
        try {
            pdfCore = new MuPDFCore(mContext, buffer);

        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
            return null;
        }
        return pdfCore;
    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onPause() {

    }
}
