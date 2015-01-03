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
import com.artifex.mupdfdemo.SearchTaskResult;

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
    private SearchTask mSearchTask;
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

        // casting the pdf layout to a relative layout
        escuelaSabaticaLayout = (RelativeLayout) escuelaSabaticaView.findViewById(R.id.pdflayout);

        // opening the pdf file and setting it to a mupdf core object
        pdfCore = openPdfFile(Uri.decode(Constants.pathToPdf));

        // if we returned a non null null object then start the view
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

        mSearchTask = new SearchTask(mContext, pdfCore) {
            @Override
            protected void onTextFound(SearchTaskResult result) {
                SearchTaskResult.set(result);
                pdfReaderView.setDisplayedViewIndex(result.pageNumber);
                pdfReaderView.resetupChildren();
            }
        };

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

    public void searchQuery(int direction, String query) {
        int displayPage = pdfReaderView.getDisplayedViewIndex();
        SearchTaskResult searchTaskResult = SearchTaskResult.get();
        int searchPage = searchTaskResult != null ? searchTaskResult.pageNumber : -1;
        mSearchTask.go(query, direction, displayPage, searchPage);
    }

    @Override
    public void onDestroy() {
        if(pdfCore != null) {
            pdfCore.onDestroy();
        }

        pdfCore = null;
        super.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        if(mSearchTask != null) {
            mSearchTask.stop();
        }
    }
}
