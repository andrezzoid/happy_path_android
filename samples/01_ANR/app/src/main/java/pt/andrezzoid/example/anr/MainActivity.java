/**
 * README:
 * =======
 *
 * When running this application, click on the Long operation button and right away click 
 * several times and at a fast pace on the dummy button. You might just get an ANR!
 *
 */

package pt.andrezzoid.example.anr;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnLongOp = (Button) findViewById(R.id.btn_long_op);
        btnLongOp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FIXME: DON'T DO THIS IN PRODUCTION CODE!!!
                // This code executes on the UI Thread and it will cause it to block and the System
                // to show an ANR (Application Not Responding). This is the worst thing that can
                // happen to your app. Your users will eventually decide to terminate your app and
                // probably1 uninstall it!
                sleepUninterruptibly(6000);
            }
        });

        Button btnDumb = (Button) findViewById(R.id.btn_dumb);
        btnDumb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, R.string.dumb_button, Toast.LENGTH_SHORT).show();
            }
        });

    }

    /**
     * Sleeps for the given time even if InterruptedException is thrown
     * @param millis
     */
    public static void sleepUninterruptibly(int millis){
        long remaining = millis;
        long end = System.currentTimeMillis() + remaining;
        boolean interrupted = false;
        try {
            do {
                try {
                    Thread.sleep(remaining);
                    return;
                } catch (InterruptedException e) {
                    interrupted = true;
                    long now = System.currentTimeMillis();
                    remaining = end - now;
                }
            } while (true);
        }finally {
            if (interrupted) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
