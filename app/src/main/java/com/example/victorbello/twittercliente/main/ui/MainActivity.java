package com.example.victorbello.twittercliente.main.ui;

/**
 * Created by victorbello on 21/07/16.
 */

import android.os.Bundle;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.victorbello.twittercliente.LoginActivity;
import com.twitter.sdk.android.Twitter;

import com.example.victorbello.twittercliente.R;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabs;
    private ViewPager container;


    @Override
    public void onCreate(Bundle savedinstaceState){
        super.onCreate(savedinstaceState);
        setContentView(R.layout.activity_main);

        toolbar=(Toolbar) findViewById(R.id.toolbar);
        tabs=(TabLayout) findViewById(R.id.tabs);
        container=(ViewPager) findViewById(R.id.container);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==R.id.action_logout){
            logout();
        }
        return super.onOptionsItemSelected(item);
    }

    private void logout(){
        Twitter.logOut();
        Intent intent=new Intent(this, LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP
                        |Intent.FLAG_ACTIVITY_NEW_TASK
                        |Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
