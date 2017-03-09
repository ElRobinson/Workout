package com.robinson.luis.sevenminutesworkout;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

public class TelaVideos extends AppCompatActivity {


    WebView webView;
    TextView txtTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_videos);

        webView = (WebView) findViewById(R.id.webView);
        txtTitulo = (TextView) findViewById(R.id.txtNomeExercicio);

        webView.getSettings().setJavaScriptEnabled(true);

        webView.loadUrl("www.youtube.com/embed/" + "nMSmdff4HGM" + "?autoplay=1&vq=small");
        webView.setWebChromeClient(new WebChromeClient());

        String nomeVideo = getIntent().getExtras().getString("nomeVideo");
        txtTitulo.setText(nomeVideo);
    }

    private class MyBroser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }

}
