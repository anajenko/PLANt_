package si.uni_lj.fe.tnuv.plant;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Objects;

public class Razpis1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razpis1);

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);

        Intent mIntent = getIntent();
        int st = mIntent.getIntExtra("stevilkaVpolju", -1);
        String naslov = mIntent.getStringExtra("naslov");
        String opis = mIntent.getStringExtra("opis");

        TextView tv1 = findViewById(R.id.razpisXtv);
        tv1.setText("RAZPIS " + st + ":");
        TextView tv2 = findViewById(R.id.razpisXnaslov);
        tv2.setText(naslov);
        TextView tv3 = findViewById(R.id.razpisXopis);
        tv3.setText(opis);
    }

    public void finishRazpis(View v) {

        Razpis1.this.finish();
    }
}