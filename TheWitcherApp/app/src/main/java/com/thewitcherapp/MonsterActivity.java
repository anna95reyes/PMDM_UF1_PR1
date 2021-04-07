package com.thewitcherapp;

import android.content.Context;
import android.os.Bundle;
import android.util.Xml;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

public class MonsterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monster);

        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.setWebChromeClient(new WebChromeClient());

        String html = Loader.loadFileFromAssets(this, "monster.html");
        String title = "title";
        String intro = "intro";
        String author = "author";
        String detail = "detail";
        html = html.replaceAll("\\{\\{TITLE\\}\\}", title);
        html = html.replaceAll("\\{\\{INTRO\\}\\}", intro);
        html = html.replaceAll("\\{\\{AUTHOR\\}\\}", author);
        html = html.replaceAll("\\{\\{DETAIL\\}\\}", detail);
    }
}
