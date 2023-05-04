package si.uni_lj.fe.tnuv.plant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.SearchView;

import java.util.ArrayList;

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

        razpiski = new String[]{"Razpis 1: Kupovanje novih panjev", "Razpis 2: Pomoč za žrtve poplave", "Razpis 3: Gnojila",
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
    }

    public void startActivitySPOK(View v) {
        Intent intent = new Intent(ActivityRazpisi.this, ActivitySPOK.class);
        startActivity(intent);
    }

    public void startActivityUrnik(View v) {
        Intent intent = new Intent(ActivityRazpisi.this, ActivityUrnik.class);
        startActivity(intent);
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
