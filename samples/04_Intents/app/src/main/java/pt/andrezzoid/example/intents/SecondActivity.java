package pt.andrezzoid.example.intents;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;


public class SecondActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // getIntent() gets us the Intent used to call this Activity
        // getExtras() gets us any extra values sent with the Intent
        Intent callerIntent = getIntent();
        if(callerIntent.getExtras() != null) {
            int someValue = callerIntent.getIntExtra("SOME_VALUE", 0);
            String toastTxt = "The answer to life, the universe and everything is: " + someValue;
            Toast.makeText(this, toastTxt, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("SOME_INT", 10);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        int some = savedInstanceState.getInt("SOME_INT");
    }
}
