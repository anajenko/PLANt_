package si.uni_lj.fe.tnuv.plant;

import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.HashMap;

public class RazpisiJsonParser {
    private static final String TAG = RazpisiJsonParser.class.getSimpleName();
    private ArrayList<HashMap<String, String>> razpisiList = new ArrayList<>();

    public ArrayList<HashMap<String, String>> parseToArrayList(String jsonStr){
        try {
            JSONObject jsonObj = new JSONObject(jsonStr);

            // Getting JSON Array node
            JSONArray razpisi1 = jsonObj.getJSONArray("razpisi");

            // looping through All Razpisi
            for (int i = 0; i < razpisi1.length(); i++) {
                JSONObject r = razpisi1.getJSONObject(i);

                String num = r.getString("num");
                String title = r.getString("title");
                String description = r.getString("description");

                // tmp hash map for single contact
                HashMap<String, String> razpis1 = new HashMap<>();

                // adding each child node to HashMap key => value
                razpis1.put("num", num);
                razpis1.put("title", title);
                razpis1.put("description", description);

                // adding contact to contact list
                razpisiList.add(razpis1);
            }
        } catch (final JSONException e) {
            Log.e(TAG, "Json parsing error: " + e.getMessage());
        }
        return razpisiList;
    }
}






