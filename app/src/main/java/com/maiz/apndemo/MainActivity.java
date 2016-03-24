package com.maiz.apndemo;


import android.app.Activity;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button netstate = (Button)findViewById(R.id.netstate);
        final TextView netview = (TextView)findViewById(R.id.netView);
        netstate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager manger = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo NI = manger.getActiveNetworkInfo();
                if (NI != null && NI.isConnectedOrConnecting()){
                    netview.setText("可用");
                }else{
                    netview.setText("不可用");
                }
            }
        });

        Button button=(Button)findViewById(R.id.button);
        final TextView textView =(TextView)findViewById(R.id.textView);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
                String extraInfo = networkInfo.getExtraInfo();
                textView.setText(extraInfo);
            }
        });
    }
}
