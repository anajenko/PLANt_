package si.uni_lj.fe.tnuv.plant;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.Objects;

public class RazpisiFragment extends Fragment {

    public RazpisiFragment() {
        // Required empty public constructor
    }

    ListView list;
    ListViewAdapter adapter;
    SearchView editsearch;
    String[] razpiski;
    ArrayList<Razpis> arraylist = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        razpiski = new String[]{"Razpis 1: Kupovanje novih panjev", "Razpis 2: Denarna pomoč za žrtve poplave", "Razpis 3: Gnojila",
                "Razpis 4: Predsednik kmetijske zadruge", "Razpis 5: Finančni dodatek kmetu", "Razpis 6: Podarjena koza", "Razpis 7: Brezplačno seme češnjevcev", "Razpis 8: Prehranski dodatki za kokoši",
                "Razpis 9: Avtomatska vrata za kokošnjak","Razpis 10: Samovozeča kosilnica","Razpis 11: Tečaj 'candlinga'"};

        // Locate the ListView in listview_main.xml
        list = (ListView) requireView().findViewById(R.id.nabor_razpisov);
        System.out.println(list);

        for (int i = 0; i < razpiski.length; i++) {
            Razpis animalNames = new Razpis(razpiski[i]);
            // Binds all strings into an array
            arraylist.add(animalNames);
        }

        // Pass results to ListViewAdapter Class
        adapter = new ListViewAdapter(getActivity(), arraylist);

        // Binds the Adapter to the ListView
        list.setAdapter(adapter);

        // Locate the EditText in listview_main.xml
        editsearch = (SearchView) getView().findViewById(R.id.search);
        ///editsearch.setOnQueryTextListener();

        //drugi del
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(getActivity(), Razpis1.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), Razpis2.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), Razpis3.class));
                        break;
                }

            }
        });

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_razpisi, container, false);
    }

}