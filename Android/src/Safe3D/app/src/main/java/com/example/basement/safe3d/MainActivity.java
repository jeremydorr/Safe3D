package com.example.basement.safe3d;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    boolean safe;
    RadioGroup tempGroup;
    RadioButton btnCelsius;
    RadioButton btnFahrenheight;
    Button done;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        WebView mywebView = (WebView) findViewById(R.id.webView);
        mywebView.getSettings().setJavaScriptEnabled(true);
        mywebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        mywebView.loadUrl("https://www.youtube.com/embed/2GQNxRIs8K0");
        mywebView.setWebViewClient(new WebViewClient());

        image = (ImageView) findViewById(R.id.imageView2);
        if(safe==true){
            image.setImageResource(R.drawable.safe);
        }
        else {
            image.setImageResource(R.drawable.unsafe);
        }

        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            setContentView(R.layout.settingslayout);
            tempGroup = (RadioGroup) findViewById(R.id.btnGroup);
            done = (Button) findViewById(R.id.btnDone);
            done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int selectedId = tempGroup.getCheckedRadioButtonId();
                    if (selectedId == R.id.tmpCelsius){
                        safe = false;
                    }
                    else {
                        safe=true;
                    }
                    renderMain();
                }
            });
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.basement.safe3d/http/host/path")
        );
        AppIndex.AppIndexApi.start(client, viewAction);
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        Action viewAction = Action.newAction(
                Action.TYPE_VIEW, // TODO: choose an action type.
                "Main Page", // TODO: Define a title for the content shown.
                // TODO: If you have web page content that matches this app activity's content,
                // make sure this auto-generated web page URL is correct.
                // Otherwise, set the URL to null.
                Uri.parse("http://host/path"),
                // TODO: Make sure this auto-generated app URL is correct.
                Uri.parse("android-app://com.example.basement.safe3d/http/host/path")
        );
        AppIndex.AppIndexApi.end(client, viewAction);
        client.disconnect();
    }

    public void renderMain() {
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        WebView mywebView = (WebView) findViewById(R.id.webView);
        mywebView.getSettings().setJavaScriptEnabled(true);
        mywebView.getSettings().setPluginState(WebSettings.PluginState.ON);
        mywebView.loadUrl("https://www.youtube.com/embed/2GQNxRIs8K0");
        mywebView.setWebViewClient(new WebViewClient());

        image = (ImageView) findViewById(R.id.imageView2);
        if(safe==true){
            image.setImageResource(R.drawable.safe);
        }
        else {
            image.setImageResource(R.drawable.unsafe);
        }
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
}
