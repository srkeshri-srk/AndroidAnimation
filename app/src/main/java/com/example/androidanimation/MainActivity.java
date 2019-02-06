package com.example.androidanimation;

import android.annotation.TargetApi;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout mlistlayout;

    private ImageView mprofileimage;
    private TextView mnametext;
    private TextView mdesctext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mlistlayout = (LinearLayout) findViewById(R.id.listlayout);
        mprofileimage = (ImageView)findViewById(R.id.profieimage);
        mnametext = (TextView)findViewById(R.id.nametext);
        mdesctext = (TextView)findViewById(R.id.desctext);

        mlistlayout.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View v) {

                Intent sharedintent = new Intent(MainActivity.this,sharedActivity.class);

                Pair[] pairs = new Pair[3];
                pairs[0] = new Pair<View,String>(mprofileimage,"imageTransition");
                pairs[1] = new Pair<View,String>(mnametext,"nameTransition");
                pairs[2] = new Pair<View,String>(mdesctext,"descTransition");

                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(MainActivity.this,pairs);
                startActivity(sharedintent, options.toBundle());
            }
        });
    }
}
