package com.example.minhtien.tiptrips;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

/**
 * Created by minhtien on 8/19/2016.
 */
public class DetailActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        WebView mWebView = (WebView) findViewById(R.id.wv_details_tip);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.loadUrl("file:///android_asset/1.html");
    }
}
