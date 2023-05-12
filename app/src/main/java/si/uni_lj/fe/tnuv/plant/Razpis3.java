package si.uni_lj.fe.tnuv.plant;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Razpis3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_razpis3);
    }

    public void finishRazpis(View v) {

        Razpis3.this.finish();
    }
}