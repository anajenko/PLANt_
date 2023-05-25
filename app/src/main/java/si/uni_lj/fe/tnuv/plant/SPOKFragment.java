package si.uni_lj.fe.tnuv.plant;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

public class SPOKFragment extends Fragment {
    public SPOKFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button shrani = inflater.inflate(R.layout.fragment_s_p_o_k, container, false).findViewById(R.id.btn_spok_shrani);
        shrani.setOnClickListener(v -> shrani());

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_s_p_o_k, container, false);
    }
    private void shrani() {
        EditText vnosno1 = getView().findViewById(R.id.vnosno_ime);
        EditText vnosno2 = getView().findViewById(R.id.vnosno_priimek);
        EditText vnosno3 = getView().findViewById(R.id.vnosno_naslovKmetije);
        EditText vnosno4 = getView().findViewById(R.id.vnosno_katastrska);
        EditText vnosno5 = getView().findViewById(R.id.vnosno_panoga);
        EditText vnosno6 = getView().findViewById(R.id.vnosno_drugo);
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

        SharedPreferences sharedPrefs = this.getActivity().getSharedPreferences("pref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPrefs.edit();

        editor.putString(imeKljuc, ime);
        editor.putString(priimekKljuc, priimek);
        editor.putString(naslovKljuc, naslov);
        editor.putString(katastrskaKljuc, katastrska);
        editor.putString(panogaKljuc, panoga);
        editor.putString(drugoKljuc, drugo);
        ///editor.commit(); rajs apply
        editor.apply();

        ((TextView) getView().findViewById(R.id.izpis)).setText(ime + " " + priimek + " " + naslov + " " + katastrska + " " + panoga + " " + drugo);

    }
}