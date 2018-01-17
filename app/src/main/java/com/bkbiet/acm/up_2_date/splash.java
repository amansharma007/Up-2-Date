package com.bkbiet.acm.up_2_date;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread inThread=new Thread(){
        public void run()
        {
            try
            {
                sleep(3000);
            }catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            finally {
                Intent startingPt=new Intent(splash.this,Home.class);
                startActivity(startingPt);
            }
        }
        };
                inThread.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
