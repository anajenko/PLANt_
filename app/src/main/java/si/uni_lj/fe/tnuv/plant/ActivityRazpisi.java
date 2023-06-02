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
import android.widget.Toast;

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

        try {
            preberiRazpise();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        list = findViewById(R.id.nabor_razpisov);

        //***tole bo slo se ven
        list.setOnItemClickListener((parent, view, position, id) -> {
            //Toast.makeText(this, "Klik na " + position, Toast.LENGTH_SHORT).show();
            String ime = (String) ((HashMap)seznamRazpisov.get(position)).get("title");
            Toast.makeText(this, "Klik na " + ime, Toast.LENGTH_SHORT).show();
        });

        //ISKANJE
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this); //onQueryTextSubmit, onQueryTextChange

        //drugi del
        list.setOnItemClickListener((parent, view, position, id) -> {
            //***position --> katera stevilka razpisa je na position
            switch (position) {
                case 0:
                    startActivity(new Intent(ActivityRazpisi.this, Razpis1.class));
                    break;
                case 1:
                    startActivity(new Intent(ActivityRazpisi.this, Razpis2.class));
                    break;
                case 2:
                    startActivity(new Intent(ActivityRazpisi.this, Razpis3.class));
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                case 11:
                    break;
            }

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

        list = findViewById(R.id.nabor_razpisov);
        list.setAdapter(adapter); //branje razpisov iz json file
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        editsearch.clearFocus();
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
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
