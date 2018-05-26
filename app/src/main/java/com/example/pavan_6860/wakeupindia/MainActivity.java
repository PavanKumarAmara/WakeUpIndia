package com.example.pavan_6860.wakeupindia;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void signIn(View view){
        Intent homeIntent=new Intent(this,Home.class);
        try{
            startActivity(homeIntent);
        }
        catch (Exception e){
            Toast.makeText(this,getResources().getString(R.string.error_message),Toast.LENGTH_LONG).show();
        }
    }
}
