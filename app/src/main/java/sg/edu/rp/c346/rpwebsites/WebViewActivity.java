package sg.edu.rp.c346.rpwebsites;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewActivity extends AppCompatActivity {
    WebView wvWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.present);

        wvWeb = findViewById(R.id.webViewWeb);

        wvWeb.setWebViewClient(new WebViewClient());
        wvWeb.getSettings().setJavaScriptEnabled(true);
        wvWeb.getSettings().setAllowFileAccess(false);
        wvWeb.getSettings().setBuiltInZoomControls(true);

        Intent intentRecive = getIntent();
        String url = intentRecive.getStringExtra("url");
        wvWeb.loadUrl(url);
    }
}
