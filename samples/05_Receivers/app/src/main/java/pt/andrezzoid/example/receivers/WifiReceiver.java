/**
 * README:
 * =======
 *
 * This WifiReceiver gets notified with a broadcast Intent every time there's a change in
 * battery status (android.intent.action.BATTERY_CHANGED).
 *
 */

package pt.andrezzoid.example.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;
import android.util.Log;
import android.widget.Toast;

public class WifiReceiver extends BroadcastReceiver {

    public static final String TAG = WifiReceiver.class.getSimpleName();

    static final String msgNotConnected = "No Wi-Fi for you, sir!";
    static final String msgConnectedWifi = "We have Wi-fi!";

    public WifiReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive()");
        // You can access extra info within the broadcasted Intent
        NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        if(info != null) {
            boolean isConnected = info.isConnected();
            boolean isWifi = info.getType() == ConnectivityManager.TYPE_WIFI;

            if(!isConnected) {
                Toast.makeText(context, msgNotConnected, Toast.LENGTH_SHORT).show();
            }

            if(isConnected && isWifi) {
                Toast.makeText(context, msgConnectedWifi, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
