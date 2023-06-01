package si.uni_lj.fe.tnuv.plant;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.EditText;
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
import java.util.List;

import android.util.Log;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import org.json.JSONObject;


public class ActivityRazpisi extends AppCompatActivity implements SearchView.OnQueryTextListener {

    ListView list;
    private ArrayList<HashMap<String, String>> seznamRazpisov;

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
        list.setOnItemClickListener((parent, view, position, id) -> {
            //Toast.makeText(this, "Klik na " + position, Toast.LENGTH_SHORT).show();
            String ime = (String) ((HashMap)seznamRazpisov.get(position)).get("title");
            Toast.makeText(this, "Klik na " + ime, Toast.LENGTH_SHORT).show();
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

        //Toast.makeText(this, rezultat, Toast.LENGTH_LONG).show();
        seznamRazpisov = new RazpisiJsonParser().parseToArrayList(rezultat);

        SimpleAdapter adapter = new SimpleAdapter(
                this,
                seznamRazpisov,
                R.layout.list_view_items,
                new String[] {"num", "title"},
                new int[] {R.id.num, R.id.title}
        );

        list = findViewById(R.id.nabor_razpisov);
        list.setAdapter(adapter);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
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
