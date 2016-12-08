package com.sourcey.materiallogindemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class loading_icon extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_icon);

        Thread thread=new Thread(){
        @Override
        public void run(){
            try {

                synchronized(this){
                    wait(3000);
                }
            }catch(InterruptedException ex){

            }
            finally{

                Intent i=new Intent(loading_icon.this,LoginActivity.class);
                startActivity(i);
                finish();
            }

        }
    };
    thread.start();// thread objesini calistriyoruz

}
}
