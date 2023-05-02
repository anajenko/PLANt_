package si.uni_lj.fe.tnuv.plant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityUrnik extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urnik);
    }

    public void startActivitySPOK(View v) {
        Intent intent = new Intent(ActivityUrnik.this, ActivitySPOK.class);
        startActivity(intent);
    }

    public void startActivityUrnik(View v) {
        Intent intent = new Intent(ActivityUrnik.this, ActivityUrnik.class);
        startActivity(intent);
    }

    public void startActivityRazpisi(View v) {
        Intent intent = new Intent(ActivityUrnik.this, ActivityRazpisi.class);
        startActivity(intent);
    }

}
