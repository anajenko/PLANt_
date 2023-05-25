package si.uni_lj.fe.tnuv.plant;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.Objects;

public class ActivitySPOK extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_view, SPOKFragment.class, null)
                    .commit();
        }

        Objects.requireNonNull(getSupportActionBar()).setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbar_title_layout);
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
}


