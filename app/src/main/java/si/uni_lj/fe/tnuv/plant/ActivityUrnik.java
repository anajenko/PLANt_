package si.uni_lj.fe.tnuv.plant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class ActivityUrnik extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urnik);
    }

    public void startActivitySPOK(View v) {
        Intent intent = new Intent(ActivityUrnik.this, ActivitySPOK.class);
        startActivity(intent);
        overridePendingTransition(R.anim.levo_1,R.anim.levo_2);
    }

    public void startActivityUrnik(View v) {
        Intent intent = new Intent(ActivityUrnik.this, ActivityUrnik.class);
        startActivity(intent);
    }

    public void startActivityRazpisi(View v) {
        Intent intent = new Intent(ActivityUrnik.this, ActivityRazpisi.class);
        startActivity(intent);
        overridePendingTransition(R.anim.desno_1,R.anim.desno_2);
    }

}
