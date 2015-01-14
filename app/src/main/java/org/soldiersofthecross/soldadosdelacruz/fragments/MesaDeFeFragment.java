package org.soldiersofthecross.soldadosdelacruz.fragments;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Scroller;
import android.widget.TextView;

import com.commonsware.cwac.anddown.AndDown;

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
        WebView webView = new WebView(getActivity());
        AndDown markdown = new AndDown();


        String markdownHtml = markdown.markdownToHtml("#Iglesia Soldados de la Cruz \n" +
                "\n" +
                " \n" +
                "\n" +
                "##LECCION #33 \n" +
                "\n" +
                "###EPISTOLA UNIVERSAL DE  JUDAS \n" +
                "\n" +
                " \n" +
                " \n" +
                "\n" +
                "#####VERSÍCULO PARA MEMORIZAR \n" +
                "\n" +
                "```“Conservaos en el amor de Dios, esperando la misericordia de nuestro Señor Jesucristo, para vida eterna”.  \n" +
                "Judas 21.``` \n" +
                " \n" +
                "\n" +
                "Estudiar con responsabilidad una epístola de pocas líneas, pero llena de poderosas palabras de la gracia celestial. \n" +
                " \n" +
                "\n" +
                "OBJETIVO \n" +
                "\n" +
                "Ya en tiempos de Judas, la iglesia estaba siendo infiltrada por hombres que se presentaban como siervos de Dios, \n" +
                "pero que en realidad eran enemigos de la cruz de Cristo. El propósito de Judas es denunciar a esos traidores y \n" +
                "describir su destino final. \n" +
                "\n" +
                "VERDAD CENTRAL \n" +
                "\n" +
                "* AUTOR. Judas.  \n" +
                "* TEMA. Contender por la fe.  \n" +
                "* FECHA. 70-80 d.C. \n" +
                "\n" +
                "BOSQUEJO \n" +
                "\n" +
                " \n" +
                "\n" +
                "1.  Judas 1,2. Salutación.  \n" +
                "2.  Judas 3,4. La razón por qué fue escrita esta epístola.  \n" +
                "3.  Judas 5-16. Condenación de los falsos maestros.  \n" +
                "4.  Judas 17-23. Amonestaciones y exhortaciones.  \n" +
                "5.  Judas 24,25. Doxología. \n" +
                "\n" +
                " \n" +
                "\n" +
                "TRASFONDO \n" +
                "\n" +
                "Judas se identifica sólo como el “el hermano de Jacobo” (v.1). Los únicos hermanos en el NT que se llaman Judas \n" +
                "y Jacobo son los hermanos de Jesús (Mateo 13:55;   Marcos 6:3). Tal vez Judas mencionó a Jacobo porque la \n" +
                "importancia de su hermano por ser dirigente de la iglesia de Jerusalén serviría para aclarar su propia identidad y \n" +
                "autoridad.  \n" +
                "Esta breve pero severa epístola se escribió contra los falsos maestros que eran  antinomianos   flagrantes (es \n" +
                "decir,  enseñaban  que  la  salvación  por  gracia  les  permitía  pecar  sin  ser  condenados)  y  negaban  con  desdén  la \n" +
                "revelación apostólica original de la persona y la naturaleza de Jesucristo (v. 4). De este modo dividían a las iglesias \n" +
                "en cuanto a la fe (vv. 19-22) y la conducta (vv. 4, 8,16).  Judas describe a esos hombres como “impíos” (v.15)  \n" +
                "que “no tienen el Espíritu” (v. 19).  \n" +
                "No  se  identifica  con  claridad  a  los  destinatarios;  pero  pudieran  haber  sido  los  mismos  a  quienes  se  dirigió  la \n" +
                "segunda epístola de Pedro. \n" +
                " \n" +
                "\n" +
                "\fJudas escribió esta epístola para: \n" +
                "\n" +
                "PROPÓSITO \n" +
                "\n" +
                "1.  Advertir con urgencia a los creyentes acerca de la seria amenaza de los falsos maestros y su \n" +
                "\n" +
                "influencia subversiva dentro de las iglesias, y...  \n" +
                "\n" +
                "2.  Exhortar a todos los verdaderos creyentes que luchen “por la fe que ha sido una vez dada a los \n" +
                "\n" +
                "santos” (v.3). \n" +
                "\n" +
                " \n" +
                "\n" +
                "VISIÓN PANORÁMICA \n" +
                "\n" +
                "Después de sus saludos (vv. 1,2) Judas revela que su intención original era escribir acerca de la naturaleza de la \n" +
                "salvación (v. 3). Sin embargo, se vio obligado más bien a escribir esta epístola debido a los maestros apóstatas, \n" +
                "que pervertían la gracia de Dios, y así socavaban la verdad y la justicia en las iglesias (v.4), de deslealtad como \n" +
                "Caín (v. 11), de avaricia como Balaam (v. 11), de rebeldía como Coré (v.11), de arrogancia (vv. 8,  16), de engaño \n" +
                "(vv. 4,  12), de sensualidad (v. 19) y de divisionismo (v.19). Declara la certeza del juicio de Dios sobre todos los \n" +
                "que cometen tales pecados y da seis ejemplos del AT (vv. 5-11). Las diez características de su vida (vv. 12-16) \n" +
                "revelan cuánto merecen la ira de Dios. Se exhorta a los creyentes a cuidarse y a tener compasión con cautela de \n" +
                "los que dudan (vv. 20-23). Judas concluye con un crescendo de inspiración en su bendición (vv. 24-25). \n" +
                " \n" +
                "\n" +
                "CARACTERÍSTICAS ESPECIALES \n" +
                "\n" +
                "Son cuatro:  \n" +
                "\n" +
                "1.  Contiene la denuncia más directa y enérgica del NT contra los falsos maestros. Destaca por todas las \n" +
                "\n" +
                "generaciones la gravedad de la amenaza que siempre la falsa enseñanza presenta para la fe genuina y la \n" +
                "vida santa.  \n" +
                "\n" +
                "2.  Demuestra una preferencia por los ejemplos en series de tres:  \n" +
                "\n" +
                "a)  Tres juicios del AT (vv. 5-7),  \n" +
                "b)  Una descripción triple de los falsos maestros (v.8) y… \n" +
                "c)  Tres impíos del AT (v.11).  \n" +
                "\n" +
                "3.  Bajo la plena influencia del Espíritu Santo, Judas se refiere con libertad a las fuentes escritas:  \n" +
                "\n" +
                "a.  Escrituras del AT (vv. 5, 7, 11),  \n" +
                "b.  Tradiciones judías (vv. 9,  14,  15).  \n" +
                "\n" +
                "4.  Contiene la más majestuosa bendición del NT (vv. 24-25). \n" +
                "\n" +
                " \n" +
                "\n" +
                "UN DETALLE RELEVANTE \n" +
                "\n" +
                "JUDAS 3. Fe Que Ha Sido Una Vez Dada A Los Santos.  \n" +
                "Se les pone a los seguidores de Cristo la solemne obligación de luchar por la fe que Dios les entregó a los apóstoles \n" +
                "y a los santos (Filipenses 1:27).  \n" +
                "\n" +
                "1.  La fe consta del evangelio que proclamaron Cristo y los apóstoles. Es la fija e invariable verdad, dada por \n" +
                "el Espíritu Santo y expresada en el Nuevo Testamento. Sin embargo, la fe es más que una verdad objetiva; \n" +
                "es además una manera de vivir en amor y pureza (Colosenses 1:9-11;  1Timoteo 1:5).  Es el reino que \n" +
                "viene con poder a bautizar a todos los creyentes en el Espíritu Santo para que proclamen el Evangelio a \n" +
                "todas las naciones (Marcos 16:15-17) con señales y milagros y dones del Espíritu (Hechos 2:22; 14:3; \n" +
                "Romanos 15:19).   \n" +
                "\n" +
                "2.  El  verbo  “contender”  describe  la  batalla  que  el  fiel  creyente  debe  librar  en  defensa  de  la  fe.  Significa \n" +
                "literalmente “pelear”, “sufrir”, “estar bajo grandes tensiones” o “luchar”. Los creyentes deben esforzarse \n" +
                "al máximo en defensa de la Palabra de Dios y de la fe neotestamentaria, aun cuando eso les sea costoso y \n" +
                "angustioso. Hay que negarse a sí mismo y, si es necesario, recibir el martirio por causa del Evangelio (2Ti. \n" +
                "4:7) \n" +
                "\n" +
                " \n" +
                " \n" +
                "\n" +
                "\fPREGUNTAS PARA REPASO  \n" +
                "\n" +
                " \n" +
                "\n" +
                "1.  ¿Cuál es el tema de la epístola?  \n" +
                "\n" +
                "2.  Aproximadamente, ¿cuándo fue escrita? \n" +
                "\n" +
                "3.  Esta epístola fue escrita con dos propósitos. Identifíquelos. \n" +
                "\n" +
                "4.  Se mencionan tres personajes malos del AT. ¿Cuáles son? \n" +
                "\n" +
                "5.  Localice las diez características de los apóstatas que hay en los vs. 12-16. \n" +
                "\n" +
                "6.  Localice las tres series de tres cosas distintas que se utilizan en esta epístola. \n" +
                "\n" +
                "7.  ¿Qué ha sucedido con los ángeles “que no guardaron su dignidad”? \n" +
                "\n" +
                "8.  Localice el nombre de las ciudades vecinas de Sodoma y Gomorra. \n" +
                "\n" +
                "9.  Se mencionan en un solo versículo a un arcángel, Moisés y el diablo. ¿Qué sucedía? \n" +
                "\n" +
                "10. ¿Qué usted sabe acerca del Coré que se menciona en esta epístola? \n" +
                "\n" +
                "11. Copie la profecía de Enoc contenida en este libro. \n" +
                "\n" +
                "12. ¿Cuál es la más majestuosa bendición del NT? \n" +
                "\n" +
                " \n" +
                "\n" +
                "\f");
        webView.loadData(markdownHtml, "text/html", null);
        return webView;
    }
}
