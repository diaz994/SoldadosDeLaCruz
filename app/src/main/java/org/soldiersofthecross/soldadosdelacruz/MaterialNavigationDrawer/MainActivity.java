package org.soldiersofthecross.soldadosdelacruz.MaterialNavigationDrawer;


import android.app.FragmentManager;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import org.soldiersofthecross.soldadosdelacruz.R;
import org.soldiersofthecross.soldadosdelacruz.fragments.DonationFragment;
import org.soldiersofthecross.soldadosdelacruz.fragments.EscuelaSabaticaFragment;
import org.soldiersofthecross.soldadosdelacruz.fragments.HomeFragment;
import org.soldiersofthecross.soldadosdelacruz.fragments.InformationFragment;
import org.soldiersofthecross.soldadosdelacruz.fragments.LectureListFragment;
import org.soldiersofthecross.soldadosdelacruz.fragments.MesaDeFeFragment;
import org.soldiersofthecross.soldadosdelacruz.fragments.NewsFragment;
import org.soldiersofthecross.soldadosdelacruz.fragments.RadioFragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import it.neokree.materialnavigationdrawer.MaterialAccountListener;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.MaterialSection;
import it.neokree.materialnavigationdrawer.MaterialAccount;

public class MainActivity extends MaterialNavigationDrawer implements MaterialAccountListener, LectureListFragment.OnFragmentInteractionListener {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    private final static String TAG = "MainActivity";

    private MaterialAccount account;
    private MaterialSection home;
    private MaterialSection escuelaSabatica;
    private MaterialSection mesaDeFe;
    private MaterialSection noticias;
    private MaterialSection radio;
    private MaterialSection donacion;
    private MaterialSection informacion;
    private MaterialSection configuracion;

    private EscuelaSabaticaFragment escuelaSabaticaFragment;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        SearchManager searchManager = (SearchManager) getBaseContext().getSystemService(Context.SEARCH_SERVICE);
        Log.d(TAG, "Search Manager = " + searchManager.toString());
        //MenuItem searchItem = menu.findItem(R.id.action_search);
        //Log.d(TAG, "Menu Item (searchItem) = " + searchItem.toString());
        //
        Object searchView = (Object) menu.findItem(R.id.action_search).getActionView();
        Log.d(TAG, "Search View = " + searchView);
        //searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//        SearchView.OnQueryTextListener textChangeListener = new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                escuelaSabaticaFragment.searchQuery(1, query);
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return true;
//            }
//        };
//
//        searchView.setOnQueryTextListener(textChangeListener);

        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void init(Bundle savedInstanceState) {
        home = this.newSection("Home", new HomeFragment());
        escuelaSabatica = this.newSection(this.getString(R.string.sabbathSchool), new LectureListFragment());
        mesaDeFe = this.newSection(this.getString(R.string.dailyDevotional), new MesaDeFeFragment());
        noticias = this.newSection(this.getString(R.string.news), new NewsFragment());
        radio = this.newSection(this.getString(R.string.radio), new RadioFragment());
        donacion = this.newSection(this.getString(R.string.donation), new DonationFragment());
        informacion = this.newSection(this.getString(R.string.information), new InformationFragment());
        configuracion = this.newSection(this.getString(R.string.settings), new FragmentIndex());

        // Enabling portrait and landscape mode
        this.addMultiPaneSupport();

        // adding arrow animation
        this.allowArrowAnimation();

        // addding the sections
        this.addSection(home);
        this.addSection(escuelaSabatica);
        this.addSection(mesaDeFe);

        // adding a dvisior between sections
        this.addDivisor();

        // adding the news and radio sections
        this.addSection(noticias);
        this.addSection(radio);

        // adding a divisor
        this.addDivisor();

        // adding the information and donation section
        this.addSection(informacion);
        this.addSection(donacion);

        // adding a divisior
        this.addDivisor();

        // adding the settings to bottom menu
        this.addBottomSection(configuracion);
    }

    @Override
    public void onAccountOpening(MaterialAccount materialAccount) {

    }

    @Override
    public void onChangeAccount(MaterialAccount materialAccount) {

    }

    private void openPdfWithFragment() {
        escuelaSabaticaFragment = new EscuelaSabaticaFragment();
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content, escuelaSabaticaFragment).commit();
    }

    private void copyPdfToSdCard() {
        InputStream inputStream = getResources().openRawResource(R.raw.escuela_sabatica_2014);
        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(Environment.getExternalStorageDirectory() + "/soldadosdelacruz/escuelasabatica");

            byte[] buffer = new byte[inputStream.available()];

            int read = 0;


            while ((read = inputStream.read(buffer)) > 0)
                outputStream.write(buffer, 0, read);

        } catch (IOException e) {
            Log.e(TAG, e.getMessage());
        } finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

     public byte[] readFile(File file) throws IOException {
         byte[] buffer = new byte[(int) file.length()];
         InputStream inputStream = null;

         try {
             inputStream = new FileInputStream(file);
             if(inputStream.read(buffer) == -1) {
                 throw new IOException("End of file reached while trying to read the whole file");
             }
         } finally {
             try {
                 if(inputStream != null) {
                     inputStream.close();
                 }
             } catch (IOException e) {
                 Log.e(TAG, e.getMessage());
             }
         }

         return buffer;
     }

    @Override
    public void onFragmentInteraction(String id) {
        Log.d(TAG, "Position " + id + "has been clicked.");
    }

    // implementing the method when the back is pressed from a deeper fragment
    // than the initial fragment call.
    @Override
    public void onBackPressed() {

        int count = getFragmentManager().getBackStackEntryCount();

        if(count == 0) {
            Log.d(TAG, "The amount of items in back stack in onBackPressed: " + count);
            super.onBackPressed();
        } else {
            getFragmentManager().popBackStack();
        }
    }
}

