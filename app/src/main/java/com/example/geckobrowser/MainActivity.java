package com.example.geckobrowser;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.mozilla.geckoview.GeckoRuntime;
import org.mozilla.geckoview.GeckoSession;
import org.mozilla.geckoview.GeckoSessionSettings;
import org.mozilla.geckoview.GeckoView;

public class MainActivity extends AppCompatActivity {
    public String INITIAL_URL = "https://start.duckduckgo.com";
    private GeckoView mGeckoView;
    private GeckoSession mGeckoSession;
    private GeckoSessionSettings.Builder settingsBuilder = new GeckoSessionSettings.Builder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupGeckoView();
    }

    private void setupGeckoView() {
        mGeckoView = findViewById(R.id.geckoView);
        GeckoRuntime runtime = GeckoRuntime.create(this);
        mGeckoSession = new GeckoSession(settingsBuilder.build());

        mGeckoSession.open(runtime);
        mGeckoView.setSession(mGeckoSession);
        mGeckoSession.loadUri(INITIAL_URL);

    }

}


