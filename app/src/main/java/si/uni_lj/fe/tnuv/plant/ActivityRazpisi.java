package si.uni_lj.fe.tnuv.plant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityRazpisi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int layoutId = getIntent().getIntExtra("layoutId", 0);

        setContentView(R.layout.activity_razpisi);
        populateListView();
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

    private void populateListView() {
        String[] razpisi = getResources().getStringArray(R.array.reg_nabor_razpisov);
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.list_item, razpisi);

        ListView listView = findViewById(R.id.nabor_razpisov);
        listView.setAdapter(adapter);

        AdapterView.OnItemClickListener mListener = (parent, view, position, id) ->
                Toast.makeText(getApplicationContext(), razpisi[position], Toast.LENGTH_SHORT).show();
        listView.setOnItemClickListener(mListener);
    }

}
