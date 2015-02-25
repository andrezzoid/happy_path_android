/**
 * README:
 * =======
 *
 * This Application tries to give an understanding about Intents. It shows both Explicit and
 * Implicit Intent examples. It doesn't matter if you don't feel confortable with Views and Button
 * click events, just try to check out the Intent code.
 *
 */

package pt.andrezzoid.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.provider.CalendarContract;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Calendar;


public class MainActivity extends ActionBarActivity {

    Button startActivity;
    Button startActivityExtra;
    EditText url;
    Button openUrl;
    Button openContactList;
    Button createEvent;
    Button unknown;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity = (Button) findViewById(R.id.btn_start_activity);
        startActivityExtra = (Button) findViewById(R.id.btn_start_activity_extra);
        url = (EditText) findViewById(R.id.et_url);
        openUrl = (Button) findViewById(R.id.btn_open_url);
        openContactList = (Button) findViewById(R.id.btn_open_contact_list);
        createEvent = (Button) findViewById(R.id.btn_create_event);
        unknown = (Button) findViewById(R.id.btn_unknown);

        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                // Explicit Intent for SecondActivity.class. It calls that Activity right away.
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

        startActivityExtra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                // Explicit Intent for SecondActivity.class. It calls that Activity right away
                // with an extra Integer value 42.
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("SOME_VALUE", 42);
                startActivity(intent);
            }
        });

        openUrl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                // Implicit Intent for a VIEW Action. This tells the system you want to view
                // whatever is in the Data (some URL). It then decides which app will best fit
                // your request.
                Uri uri = Uri.parse(url.getText().toString());
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(uri);
                startActivity(intent);
            }
        });

        openContactList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                // Another Implicit Intent for a VIEW Action. This time the Data is different, so
                // the system will analyze it and call the best app.
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("content://contacts/people/"));
                startActivity(intent);
            }
        });

        createEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Define event date/time
                Calendar beginTime = Calendar.getInstance();
                beginTime.set(2015, Calendar.FEBRUARY, 25, 19, 30);
                Calendar endTime = Calendar.getInstance();
                endTime.set(2015, Calendar.FEBRUARY, 25, 21, 00);

                //
                // Implicit Intent for an INSERT Action. Again, the system will decide
                // which app will be the best fit.
                // It can also send extra values that may get used on the called Activity.
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                        .putExtra(CalendarContract.Events.TITLE, "The Happy Path to Android development")
                        .putExtra(CalendarContract.Events.EVENT_LOCATION, "ISCTE");
                startActivity(intent);
            }
        });

        unknown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //
                // Implicit Intent an unknown Action. The app just stops because it can fulfill
                // your request.
                Intent intent = new Intent("some.unknown.shit");
                startActivity(intent);
            }
        });
    }

}
