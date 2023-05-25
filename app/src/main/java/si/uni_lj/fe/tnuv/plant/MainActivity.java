package si.uni_lj.fe.tnuv.plant;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ///Intent intent = new Intent(MainActivity.this, SPOKFragment.class);
        ///startActivity(intent);
        if (savedInstanceState == null) {
            Bundle bundle = new Bundle();
            bundle.putInt("some_int", 0);

            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_view, SPOKFragment.class, bundle)
                    .commit();
        }

        FragmentManager fragmentManager = getSupportFragmentManager();

        ImageButton btnSPOK = findViewById(R.id.btn_spok);
        btnSPOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///Intent intent = new Intent(MainActivity.this, ActivitySPOK.class);
                ///startActivity(intent);

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.levo_1,
                                R.anim.levo_2,
                                R.anim.desno_1,
                                R.anim.desno_2
                        )
                        .replace(R.id.fragment_view, SPOKFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        ImageButton btnURNIK = findViewById(R.id.btn_urnik);
        btnURNIK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///Intent intent = new Intent(MainActivity.this, ActivityUrnik.class);
                ///startActivity(intent);

                ///treba popravt!
                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.levo_1,
                                R.anim.levo_2,
                                R.anim.desno_1,
                                R.anim.desno_2
                        )
                        .replace(R.id.fragment_view, UrnikFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });

        ImageButton btnRAZPISI = findViewById(R.id.btn_razpisi);
        btnRAZPISI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ///Intent intent = new Intent(MainActivity.this, ActivityRazpisi.class);
                ///startActivity(intent);

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.desno_1,
                                R.anim.desno_2,
                                R.anim.levo_1,
                                R.anim.levo_2
                        )
                        .replace(R.id.fragment_view, RazpisiFragment.class, null)
                        .setReorderingAllowed(true)
                        .addToBackStack("name")
                        .commit();
            }
        });
    }
}