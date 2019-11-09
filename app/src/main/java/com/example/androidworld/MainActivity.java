package com.example.androidworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText mWebsiteEditText, mLocationEditText, mShareEditText;
    public static final String LOG_TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(LOG_TAG, "App has been created...!");
        mWebsiteEditText = (EditText)findViewById(R.id.website_editText);
        mLocationEditText = (EditText)findViewById(R.id.location_editText);
        mShareEditText = (EditText)findViewById(R.id.share_editText);
    }

    public void shareText(View view) {
        String txt = mShareEditText.getText().toString();
        String mimeType = "text/plain";
        ShareCompat.IntentBuilder
                .from(this)
                .setType(mimeType)
                .setChooserTitle(R.string.share_button)
                .setText(txt)
                .startChooser();


    }

    public void openLocation(View view) {
        String loc = mLocationEditText.getText().toString();
        Uri locationUri = Uri.parse("geo:0,0?q=" + loc);
        Intent locationIntent = new Intent(Intent.ACTION_VIEW, locationUri);
        if(locationIntent.resolveActivity(getPackageManager()) != null){
            startActivity(locationIntent);
        }else{
            Log.d("Implicit Intents","Can't handle this!");
        }
    }

    public void opeWebsite(View view) {
        String url = mWebsiteEditText.getText().toString();
        Uri webpage = Uri.parse(url);
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, webpage);
        if(websiteIntent.resolveActivity(getPackageManager()) != null){
            startActivity(websiteIntent);
        }else{
            Log.d("Implicit Intents","Can't handle this!");
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(LOG_TAG, "App has started...!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(LOG_TAG, "App has resumed...!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(LOG_TAG, "App has paused...!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(LOG_TAG, "App has stopped...!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(LOG_TAG, "App has been destroyed...!");
    }
}
