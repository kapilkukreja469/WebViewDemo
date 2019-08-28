package com.example.webviewdemo.web_fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.webviewdemo.MainActivity;
import com.example.webviewdemo.R;

public class GoogleFragment extends Fragment {
    WebView webView;
    String currentUrl[];
//    final FragmentActivity fragmentActivity=new FragmentActivity();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.google_fragment, container, false);
        webView = view.findViewById(R.id.google);
        final MainActivity mainActivity = new MainActivity();
        webView.loadUrl("https://www.google.com/");
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                currentUrl = url.split("=", 4);
                Log.d("Url", url);
                MainActivity.mTextMessage.setText(url);
                Log.d("Url", currentUrl[3]);
//                Logic part
//                if (currentUrl[3].equals("facebook")) {
//                    mainActivity.onFragmentChange(new FacebookFragment());
//                }
//                if (currentUrl[3].equals("twitter")) {
//                    mainActivity.onFragmentChange(new TwitterFragment());
//                }
//                if (currentUrl[3].equals("instagram")) {
//                    mainActivity.onFragmentChange(new InstagramFragment());
//                }
//                if (currentUrl[3].equals("gmail")) {
//                    mainActivity.onFragmentChange(new GmailFragment());
//                }
                return true;
            }
        });
        return view;
    }

    //    public void fragmentChange(Fragment fragment) {
//       fragmentActivity.getSupportFragmentManager().beginTransaction()
//                .replace(R.id.frame, fragment)
//                .commit();
//    }
//    @Override
//    public void onBackPressed() {
//        if (webView.canGoBack()) {
//            webView.goBack();
//        } else {
//            super.onBackPressed();
//        }
//    }
}