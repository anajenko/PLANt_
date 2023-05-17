package si.uni_lj.fe.tnuv.plant;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Objects;

public class ActivityRazpisi extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] razpiski;
    ArrayList<Razpis> arraylist = new ArrayList<Razpis>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razpisi);

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);

        razpiski = new String[]{"Razpis 1: Kupovanje novih panjev", "Razpis 2: Denarna pomoč za žrtve poplave", "Razpis 3: Gnojila",
                "Razpis 4: Predsednik kmetijske zadruge", "Razpis 5: Finančni dodatek kmetu", "Razpis 6: Podarjena koza", "Razpis 7: Brezplačno seme češnjevcev", "Razpis 8: Prehranski dodatki za kokoši",
                "Razpis 9: Avtomatska vrata za kokošnjak","Razpis 10: Samovozeča kosilnica","Razpis 11: Tečaj 'candlinga'"};

        // Locate the ListView in listview_main.xml
        list = (ListView) findViewById(R.id.nabor_razpisov);

        for (int i = 0; i < razpiski.length; i++) {
            Razpis animalNames = new Razpis(razpiski[i]);
            // Binds all strings into an array
            arraylist.add(animalNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(this, arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) findViewById(R.id.search);
        editsearch.setOnQueryTextListener(this);

        //drugi del
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
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

            }
        });
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
        Intent intent = new Intent(ActivityRazpisi.this, ActivityRazpisi.class);
        startActivity(intent);
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }
    @Override
    public boolean onQueryTextChange(String newText) {
        adapter.filter(newText);
        return false;
    }

}
