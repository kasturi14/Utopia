package com.app.kasturi.utopiafinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {

    private ImageView icon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        icon = (ImageView)findViewById(R.id.icon_image);

        Animation animation = AnimationUtils.loadAnimation(this,R.anim.transition);

        icon.startAnimation(animation);

        final Intent i = new Intent(this,MainActivity.class);

        Thread timer = new Thread()
        {
            public void run()
            {
                try{
                    sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally
                {
                    startActivity(i);
                    finish();
                }
            }
        };
        timer.start();
    }
}
