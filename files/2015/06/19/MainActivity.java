package com.xinics.signalrsample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import microsoft.aspnet.signalr.client.Platform;
import microsoft.aspnet.signalr.client.SignalRFuture;
import microsoft.aspnet.signalr.client.http.android.AndroidPlatformComponent;
import microsoft.aspnet.signalr.client.hubs.HubConnection;
import microsoft.aspnet.signalr.client.hubs.HubProxy;
import microsoft.aspnet.signalr.client.hubs.SubscriptionHandler1;


public class MainActivity extends ActionBarActivity {

    HubConnection mConnection;
    HubProxy mHub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialize();
        prepareGetMessage();
        connectToServer();
    }

    private void initialize() {
        String serverUrl = "http://serverl.url";
        String hubName = "hubname";

        Platform.loadPlatformComponent(new AndroidPlatformComponent());
        mConnection = new HubConnection(serverUrl);
        mHub = mConnection.createHubProxy(hubName);

        Button button = (Button) findViewById(R.id.button);
        final EditText editText = (EditText) findViewById(R.id.editText);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage( editText.getText().toString() );
            }
        });
    }

    private void connectToServer() {
        try {
            SignalRFuture<Void> awaitConnection = mConnection.start();
            awaitConnection.get();
            Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show();
        } catch(Exception e) {
            Log.e("SignalR", "Failed to connect to server");
        }
    }

    private void prepareGetMessage() {
        mHub.on("hello", new SubscriptionHandler1<String>() {
            @Override
            public void run(final String msg) {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
                    }
                });
            }
        }, String.class);
    }

    private void sendMessage(String msg) {
        try {
            mHub.invoke("hello", msg).get();
        } catch( Exception e ){
            Log.e("SignalR", "Fail to send message");
        }
    }

    @Override
    protected void onDestroy() {
        mConnection.stop();
        super.onDestroy();
    }
}
