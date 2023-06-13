package si.uni_lj.fe.tnuv.plant;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


import androidx.annotation.Nullable;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnFirstFragment = findViewById(R.id.btn_spok);
        Button btnSecondFragment = findViewById(R.id.btn_urnik);
        Button btnThirdFragment = findViewById(R.id.btn_razpisi);

        //Load the FirstFragment by default
        loadFragment(new SPOKFragment());

        btnFirstFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SPOKFragment());
            }
        });

        btnSecondFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new UrnikFragment());
            }
        });

        btnThirdFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new RazpisiFragment());
            }
        });
    }

    private void loadFragment(Fragment fragment) {
        // create a FragmentManager
        FragmentManager fm = getFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fm.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.flFragment, fragment);
        fragmentTransaction.commit(); // save the changes
    }


}
