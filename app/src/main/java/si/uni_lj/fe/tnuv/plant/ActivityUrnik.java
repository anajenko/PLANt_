package si.uni_lj.fe.tnuv.plant;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class ActivityUrnik extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_urnik);
    }
    
    private void IzberaDatuma(){
        CalendarView calendarView = findViewById(R.id.calendarView);
                //calendarView.setOnDateChangeListener { view, year, month, dayOfMonth ->
            // Do something when a date is selected, such as display events for that date

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
