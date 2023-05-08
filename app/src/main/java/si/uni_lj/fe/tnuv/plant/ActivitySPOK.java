package si.uni_lj.fe.tnuv.plant;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivitySPOK extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spok);

        findViewById(R.id.btn_spok_shrani).setOnClickListener(v -> shrani());
    }

    private void shrani() {
        EditText vnosno1 = findViewById(R.id.vnosno_ime);
        EditText vnosno2 = findViewById(R.id.vnosno_priimek);
        EditText vnosno3 = findViewById(R.id.vnosno_naslovKmetije);
        EditText vnosno4 = findViewById(R.id.vnosno_katastrska);
        EditText vnosno5 = findViewById(R.id.vnosno_panoga);
        EditText vnosno6 = findViewById(R.id.vnosno_drugo);
        String ime = vnosno1.getText().toString();
        String priimek = vnosno2.getText().toString();
        String naslov = vnosno3.getText().toString();
        String katastrska = vnosno4.getText().toString();
        String panoga = vnosno5.getText().toString();
        String drugo = vnosno6.getText().toString();

        String imeKljuc = getResources().getString(R.string.spok_ime_hint);
        String priimekKljuc = getResources().getString(R.string.spok_priimek_hint);
        String naslovKljuc = getResources().getString(R.string.spok_naslov_hint);
        String katastrskaKljuc = getResources().getString(R.string.spok_katastrska_hint);
        String panogaKljuc = getResources().getString(R.string.spok_panoga_hint);
        String drugoKljuc = getResources().getString(R.string.spok_drugo_hint);

        SharedPreferences sharedPrefs = getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();

        editor.putString(imeKljuc, ime);
        editor.putString(priimekKljuc, priimek);
        editor.putString(naslovKljuc, naslov);
        editor.putString(katastrskaKljuc, katastrska);
        editor.putString(panogaKljuc, panoga);
        editor.putString(drugoKljuc, drugo);
        ///editor.commit(); rajs apply
        editor.apply();

        ((TextView) findViewById(R.id.izpis)).setText(ime + " " + priimek + " " + naslov + " " + katastrska + " " + panoga + " " + drugo);

    }

    public void startActivitySPOK(View v) {
        Intent intent = new Intent(ActivitySPOK.this, ActivitySPOK.class);
        startActivity(intent);
    }

    public void startActivityUrnik(View v) {
        Intent intent = new Intent(ActivitySPOK.this, ActivityUrnik.class);
        startActivity(intent);
        overridePendingTransition(R.anim.desno_1,R.anim.desno_2);
    }

    public void startActivityRazpisi(View v) {
        Intent intent = new Intent(ActivitySPOK.this, ActivityRazpisi.class);
        startActivity(intent);
        overridePendingTransition(R.anim.desno_1,R.anim.desno_2);
    }
}


