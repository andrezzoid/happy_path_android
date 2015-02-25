/**
 * README:
 * =======
 *
 * Try to run this Application in debug mode. Each lifecycle callback has a log message so you can
 * watch the lifecycle sequence, when state is saved and restored.
 */

package pt.andrezzoid.example.activitylifecycle;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private TextView txtCount;
    private TextView txtReset;
    private Button btnCount;

    private int count = 0;

    // --------------------------------------------------------------------------------------------
    //      LIFECYCLE
    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate()");
        setContentView(R.layout.activity_main);
        txtCount = (TextView) findViewById(R.id.txt_count);
        txtReset = (TextView) findViewById(R.id.txt_reset);
        btnCount = (Button) findViewById(R.id.btn_count);

        txtReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = 0;
                txtCount.setText(Integer.toString(count));
            }
        });
        btnCount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                txtCount.setText(Integer.toString(count));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy()");
    }


    // --------------------------------------------------------------------------------------------
    //      STATE
    //


    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState()");
        count = savedInstanceState.getInt("COUNT_VALUE", 0);
        txtCount.setText(Integer.toString(count));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState()");
        outState.putInt("COUNT_VALUE", count);
    }
}
