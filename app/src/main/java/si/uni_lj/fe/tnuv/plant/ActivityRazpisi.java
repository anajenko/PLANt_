package si.uni_lj.fe.tnuv.plant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import android.widget.SimpleAdapter;

public class ActivityRazpisi extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView list;
    SearchView editsearch;
    private ArrayList<HashMap<String, String>> seznamRazpisov;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razpisi);

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);

        //NAPOLNI TABELO S PODATKI IZ JSON DATOTEKE
        list = findViewById(R.id.nabor_razpisov);
        try {
            preberiRazpise();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //ISKANJE
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this); //onQueryTextSubmit, onQueryTextChange

        //ODPIRANJE POSAMEZNEGA RAZPISA
        list.setOnItemClickListener((parent, view, position, id) -> {
            Intent n = new Intent(this, Razpis1.class);
            int st = -1;
            String naslov = null;
            String opis = null;

            //izbrani element arraylista --> stRazpisa = num
            Object o = adapter.getItem(position);
            HashMap hm = (HashMap) o;
            int stRazpisa = Integer.parseInt(hm.get("num").toString());

            for (HashMap<String, String> entry: seznamRazpisov) {
                int num = Integer.parseInt(entry.get("num"));
                if (num == stRazpisa) {
                    //v seznamRazpisov preberes
                    st = stRazpisa;
                    naslov = entry.get("title");
                    opis = entry.get("description");
                    break;
                }
            }
            //posreduj podatke: title, description
            n.putExtra("stevilkaVpolju", st);
            n.putExtra("naslov", naslov);
            n.putExtra("opis", opis);
            startActivity(n);
        });
    }

    private void preberiRazpise() throws IOException {

        InputStream is = getAssets().open("json_razpisi.json");

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String rezultat = sb.toString();

        seznamRazpisov = new RazpisiJsonParser().parseToArrayList(rezultat);
        //System.out.println(seznamRazpisov);
        adapter = new SimpleAdapter(
                this,
                seznamRazpisov,
                R.layout.list_view_items,
                new String[] {"num", "title"},
                new int[] {R.id.num, R.id.title}
        );

        list.setAdapter(adapter); //branje razpisov iz json file
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        editsearch.clearFocus();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        //OB ISKANJU FILTRIRAJ RAZPISE
        (adapter).getFilter().filter(newText);
        return false;
    }


    public void startActivitySPOK(View v) {
        Intent intent = new Intent(ActivityRazpisi.this, ActivitySPOK.class);
        startActivity(intent);
        overridePendingTransition(R.anim.levo_1,R.anim.levo_2);
    }

    public void startActivityUrnik(View v) {
        Intent intent = new Intent(ActivityRazpisi.this, ActivityUrnik.class);
        startActivity(intent);
        overridePendingTransition(R.anim.levo_1,R.anim.levo_2);
    }

    public void startActivityRazpisi(View v) {
    }
}
