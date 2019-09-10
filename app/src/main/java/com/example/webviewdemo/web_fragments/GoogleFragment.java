package com.example.webviewdemo.web_fragments;

import android.content.ClipData;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.webviewdemo.MainActivity;
import com.example.webviewdemo.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import static com.example.webviewdemo.MainActivity.mTextMessage;

public class GoogleFragment extends Fragment {
    WebView webView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.google_fragment, container, false);
        webView = new WebView(getContext());
        webView = view.findViewById(R.id.google);
        webView.loadUrl("https://www.google.com/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient() {

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageFinished(view, url);
                Log.d("url", "your current url when webpage loading.." + url);
                mTextMessage.setText(url);
                if (url.contains("https://m.facebook.com/")) {
                    MainActivity.navView.setSelectedItemId(R.id.navigation_facebook);

                }
                if (url.contains("https://mobile.twitter.com/")) {
                    MainActivity.navView.setSelectedItemId(R.id.navigation_twitter);

                }
                if (url.contains("https://www.instagram.com/")) {
                    MainActivity.navView.setSelectedItemId(R.id.navigation_instagram);

                }
                if (url.contains("https://www.google.com/intl/en-GB/gmail/about/#")) {
                    MainActivity.navView.setSelectedItemId(R.id.navigation_gmail);

                }
            }
        });
        return view;
    }

    public void fragmentChange(Fragment fragment) {
        getFragmentManager().beginTransaction()
                .replace(R.id.frame, fragment)
                .commit();
    }

    @Override
    public void onPause() {
   int f=0;
        if (f==1){
        Log.d("url","can't destroy");
        } else {
            super.onPause();
        }
    }

    @Override
    public void onDestroy() {
        int f=0;
        if (f==1){
        Log.d("url","can't destroy");
        } else {
            super.onDestroy();
        }
    }

    @Override
    public void onDetach() {
        int f=0;
        if (f==1){
            Log.d("url","can't Detach");
        } else {
            super.onDetach();
        }
    }
    //
//    @Override
//    public void onBackPressed() {
//        if (webView.canGoBack()) {
//            webView.goBack();
//        } else {
//            super.onBackPressed();
//        }
//    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_facebook:
                    Toast.makeText(getContext(), "facebook", Toast.LENGTH_SHORT).show();
                    return true;
            }
            return false;
        }
    };
}