package dhbk.android.lab3.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Random;

import dhbk.android.lab3.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showPaymentsDefault(View clickedButton) {
        Intent activityIntent = new Intent(this, CalulatorActive.class);
        startActivity(activityIntent);
    }

    public void showPaymentsWithData(View clickedButton) {
        Intent activityIntent = new Intent(this, CalulatorActive.class);
        activityIntent.putExtras(createBundle());
        startActivity(activityIntent);
    }

    public void showPaymentsWithUrl(View clickedButton) {
        Intent activityIntent = new Intent(this, TabbedActivity.class);
        startActivity(activityIntent);
    }

    private Bundle createBundle() {
        Random random = new Random();
        double amount = 30000 * (1 + random.nextInt(10));
        double discount = 0.25 * (1 + random.nextInt(60));
        String code = "MS-" + 100 * random.nextInt(100);

        Bundle info = new Bundle();
        info.putDouble("amount", amount);
        info.putDouble("discount", discount);
        info.putString("code", code);
        return info;


    }
}
