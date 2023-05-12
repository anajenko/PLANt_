package si.uni_lj.fe.tnuv.plant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Razpis2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razpis2);
    }

    public void finishRazpis(View v) {

        Razpis2.this.finish();
    }
}