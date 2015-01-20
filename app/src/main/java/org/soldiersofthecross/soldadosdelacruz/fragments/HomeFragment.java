package org.soldiersofthecross.soldadosdelacruz.fragments;


import android.graphics.Typeface;
import android.os.Bundle;
import android.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.soldiersofthecross.soldadosdelacruz.Constants;
import org.soldiersofthecross.soldadosdelacruz.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private final static String TAG = "HomeFragment";

    AsyncHttpClient client = new AsyncHttpClient();

    public HomeFragment() {
        // Required empty public constructor
    }

    // global text view which will hold the daily bible verse
    TextView tvBibleVerse;
    // global string which will hold the verse of the day
    String verseOfTheDay;

    // boolean value to determine if get request for verse of the day has been executed
    boolean hasGetRequestBeenExecuted = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d(TAG, "In onCreateView...");
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        String fontPath = "fonts/Serif12Beta-BoldItalic.otf";

        Typeface robotoTypeface = Typeface.createFromAsset(getActivity().getAssets(), fontPath);

        tvBibleVerse = (TextView) view.findViewById(R.id.tvBibleVerse);

        tvBibleVerse.setTypeface(robotoTypeface);

        if(hasGetRequestBeenExecuted == false) {
            getDailyBibleVerse();
        }

        Log.d(TAG, "verseOfTheDay in onCreateView: " + verseOfTheDay);

        return view;
    }


    private void getDailyBibleVerse() {

        client.get("http://www.ourmanna.com/verses/api/get?format=text&order=random", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String response = new String(responseBody);
                Log.d(TAG, "Status Code : " + statusCode);
                Log.d(TAG, "Response: " + response);
                verseOfTheDay = response;
                Log.d(TAG, "verseOfTheDay: " + verseOfTheDay);

                tvBibleVerse.setText(response);

                hasGetRequestBeenExecuted = true;
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d(TAG, "Failed get request.");
                Log.d(TAG, "Status Code: " + statusCode);
                Log.d(TAG, "Response: " + new String(responseBody));
                Toast.makeText(getActivity(), "Having issues at this time...", Toast.LENGTH_SHORT).show();
                hasGetRequestBeenExecuted = true;
            }
        });
    }

    @Override
    public void onPause() {
        String tempVerseOfTheDay = verseOfTheDay;
        Log.d(TAG, "OnPause of HomeFragment.");
        Log.d(TAG, "Verse of the day in onPause : " + tempVerseOfTheDay);
        Log.d(TAG, "TextView in onPause: " + tvBibleVerse);
        super.onPause();
    }

    @Override
    public void onResume() {
        String tempVerseOfTheDay = verseOfTheDay;
        Log.d(TAG, "onResume of HomeFragment.");
        Log.d(TAG, "Verse of the day in onResume : " + tempVerseOfTheDay);
        Log.d(TAG, "TextView in onResume: " + tvBibleVerse);
        tvBibleVerse.setText(tempVerseOfTheDay);
        super.onResume();
    }
}
