package com.example.jsonformsample;

import android.os.Bundle;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.Menu;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends Activity {
	WebView mWebView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        mWebView = (WebView) findViewById(R.id.webview);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        
        
       
        mWebView.addJavascriptInterface(new JavaScriptInterface(this), "Android");
      
        mWebView.loadUrl("file:///android_asset/jquery/json.html");//http://jquerymobile.com/demos/1.0a4.1/docs/forms/
 
       
      
        
        
    }

  
   
  
}