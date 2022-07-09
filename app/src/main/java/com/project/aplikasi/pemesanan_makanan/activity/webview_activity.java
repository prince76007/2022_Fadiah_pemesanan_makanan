package com.project.aplikasi.pemesanan_makanan.activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.project.aplikasi.pemesanan_makanan.R;

public class webview_activity extends AppCompatActivity {

    private WebView webview;
    private static final String TAG = "Main";
    private ProgressDialog progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.webview_activity );
        ActionBar ab = getSupportActionBar();
        ab.setHomeButtonEnabled(true);
        ab.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String url = intent.getExtras().getString("url");
        String judul = intent.getExtras().getString("judul");
        String deskripsi = intent.getExtras().getString("deskripsi");

        ab.setTitle(judul);
        ab.setSubtitle(deskripsi);

        if(adaInternet()){

            webview = (WebView) findViewById(R.id.webview);
            WebSettings settings = webview.getSettings();
            settings.setJavaScriptEnabled(true);

            //webview.setVisibility( View.INVISIBLE );
            //webview.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
            //webview.setWebChromeClient(getChromeClient());
            //webview.getSettings().setBuiltInZoomControls(false);
            //webview.getSettings().setUseWideViewPort(false);
            //webview.getSettings().setLoadWithOverviewMode(false);

            final AlertDialog alertDialog = new AlertDialog.Builder(this).create();
            progressBar = ProgressDialog.show(webview_activity.this, "Please Wait", "Loading...");

            webview.setWebViewClient(new WebViewClient() {
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
                    Log.i(TAG, "Processing..");
                    view.loadUrl(url);
                    return true;
                }

                public void onPageFinished(WebView view, String url) {
                    Log.i(TAG, "Finished.. " + url);
                    if (progressBar.isShowing()) {
                        progressBar.dismiss();
                        webview.setVisibility( View.VISIBLE );

                    }
                }

                public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                    Log.e(TAG, "Error: " + description);
                    webview.setVisibility( View.VISIBLE );
                    pesan_error_koneksi();
                }
            });
            webview.loadUrl(url);
        }
        else
        {
            pesan_error_koneksi();
        }
}

    public void pesan_error_koneksi()
    {
        AlertDialog.Builder BackAlertDialog = new AlertDialog.Builder(webview_activity.this);
        BackAlertDialog.setTitle("Error..!!");
        BackAlertDialog.setMessage("Maaf, Terdapat Error pada Koneksi Internet, Silahkan Cek Koneksi Internet Anda.");
        BackAlertDialog.setPositiveButton("Oke",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
        BackAlertDialog.show();
    }

    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {

            this.finish();

        }
    }

    private boolean adaInternet(){
        ConnectivityManager koneksi = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE);
        return koneksi.getActiveNetworkInfo() != null;
    }

    private WebChromeClient getChromeClient() {
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setCancelable(false);

        return new WebChromeClient() {
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                super.onProgressChanged(view, newProgress);
            }
        };
    }
}
