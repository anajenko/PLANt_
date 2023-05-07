package si.uni_lj.fe.tnuv.plant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ActivitySPOK extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spok);
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


