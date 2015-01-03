package org.soldiersofthecross.soldadosdelacruz.MaterialNavigationDrawer;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import org.soldiersofthecross.soldadosdelacruz.R;
import org.soldiersofthecross.soldadosdelacruz.fragments.EscuelaSabaticaFragment;
import org.soldiersofthecross.soldadosdelacruz.fragments.MesaDeFeFragment;

import it.neokree.materialnavigationdrawer.MaterialAccountListener;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;
import it.neokree.materialnavigationdrawer.MaterialSection;
import it.neokree.materialnavigationdrawer.MaterialAccount;

public class MainActivity extends MaterialNavigationDrawer implements MaterialAccountListener {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//    }

    private MaterialAccount account;
    private MaterialSection escuelaSabatica;
    private MaterialSection mesaDeFe;
    private MaterialSection noticias;
    private MaterialSection radio;
    private MaterialSection donacion;
    private MaterialSection informacion;
    private MaterialSection configuracion;

    private Fragment escuelaSabaticaFragment;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
        escuelaSabatica = this.newSection("Escuela Sabatica", new EscuelaSabaticaFragment());
        mesaDeFe = this.newSection("Mesa de fe", new MesaDeFeFragment());
        noticias = this.newSection("Noticias", new FragmentIndex());
        radio = this.newSection("Radio", new FragmentIndex());
        donacion = this.newSection("Donacion", new FragmentIndex());
        informacion = this.newSection("Informacion", new FragmentIndex());
        configuracion = this.newSection("Configuracion", new FragmentIndex());

        // Enabling portrait and landscape mode
        this.addMultiPaneSupport();

        // adding arrow animation
        this.allowArrowAnimation();

        // addding the sections
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
}

