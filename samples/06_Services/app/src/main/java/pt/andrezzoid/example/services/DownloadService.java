package pt.andrezzoid.example.services;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class DownloadService extends IntentService {

    private static final String TAG = DownloadService.class.getSimpleName();

    public DownloadService() {
        super("DownloadService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.d(TAG, "onHandleIntent()");
        Log.d(TAG, "Downloading File...");
        // TODO: Code to download file here! We're just going to fake a download for 10seconds.
        ThreadUtils.sleepUninterruptibly(10000);
        Log.d(TAG, "File Downloaded");
    }

}
