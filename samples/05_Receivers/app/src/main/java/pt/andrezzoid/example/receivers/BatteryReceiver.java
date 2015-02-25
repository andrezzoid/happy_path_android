/**
 * README:
 * =======
 *
 * This BatteryReceiver gets notified with a broadcast Intent every time there's a change in
 * battery status (android.intent.action.BATTERY_CHANGED).
 *
 */

package pt.andrezzoid.example.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

public class BatteryReceiver extends BroadcastReceiver {

    public static final String TAG = BatteryReceiver.class.getSimpleName();

    public BatteryReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive()");
        // You can access extra info within the broadcasted Intent
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);

        float batteryPct = level / (float)scale;
        String batteryTxt = String.format("Battery @ %d percent", batteryPct);
        Toast.makeText(context, batteryTxt, Toast.LENGTH_SHORT).show();
    }
}
