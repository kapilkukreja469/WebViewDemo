package com.example.webviewdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.example.webviewdemo.web_fragments.FacebookFragment;
import com.example.webviewdemo.web_fragments.GmailFragment;
import com.example.webviewdemo.web_fragments.GoogleFragment;
import com.example.webviewdemo.web_fragments.InstagramFragment;
import com.example.webviewdemo.web_fragments.TwitterFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static EditText mTextMessage;
    public static BottomNavigationView navView;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_google:
                    onFragmentChange(new GoogleFragment());
                    return true;
                case R.id.navigation_facebook:
                    onFragmentChange(new FacebookFragment());
                    return true;
                case R.id.navigation_twitter:
                    onFragmentChange(new TwitterFragment());
                    return true;
                case R.id.navigation_gmail:
                    onFragmentChange(new GmailFragment());
                    return true;
                case R.id.navigation_instagram:
                    onFragmentChange(new InstagramFragment());
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navView = findViewById(R.id.nav_view);
        getSupportActionBar().hide();
        onFragmentChange(new GoogleFragment());
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    public void onBackClick(View view) {
        navView.setSelectedItemId(R.id.navigation_google);

    }

    public void onClick(View view) {
        Toast.makeText(this, "Settings enabled", Toast.LENGTH_SHORT).show();
    }

    public void onFragmentChange(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, fragment)
                .commit();
    }

}
