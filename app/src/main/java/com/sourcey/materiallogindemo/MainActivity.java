package com.sourcey.materiallogindemo;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.media.Image;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ActionBarDrawerToggle actionBarDrawerToggle;
    private DrawerLayout drawerLayout;
    private  ListView navList;
    private FragmentTransaction fragmentTransaction;
    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




        drawerLayout = (DrawerLayout)findViewById(R.id.drawerLayout);
        navList=(ListView)findViewById(R.id.navList);
        ArrayList<String> navArray= new ArrayList<String>();
        navArray.add("Home");
        navArray.add("menü 1");
        navArray.add("menü 2");
        navArray.add("menü 3");
        navArray.add("menü 4");
        navArray.add("menü 5");


        navList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_activated_1, navArray);
        navList.setAdapter(adapter);


        navList.setOnItemClickListener(this);
        actionBarDrawerToggle =new ActionBarDrawerToggle(this, drawerLayout, R.string.opendrawer, R.string.closedrawer);
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setIcon(R.drawable.logo1);

        fragmentManager = getSupportFragmentManager();


        loadSelection(0);
    }
    private void loadSelection(int i){
        navList.setItemChecked(i, true);

        switch (i){
            case 0:
                FragmentHome fragmentHome = new FragmentHome();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmenHolder, fragmentHome);
                fragmentTransaction.commit();

                break;
            case 1:
                Fragment1 fragment1 = new Fragment1();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmenHolder, fragment1);
                fragmentTransaction.commit();
                break;
            case 2:
                Fragment2 fragment2 = new Fragment2();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmenHolder, fragment2);
                fragmentTransaction.commit();
                break;
            case 3:
                Fragment3 fragment3 = new Fragment3();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmenHolder, fragment3);
                fragmentTransaction.commit();
                break;
            case 4:
                Fragment4 fragment4 = new Fragment4();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmenHolder, fragment4);
                fragmentTransaction.commit();
                break;
            case 5:
                Fragment5 fragment5 = new Fragment5();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragmenHolder, fragment5);
                fragmentTransaction.commit();
                break;
        }


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.anasayfamenu, menu);
        return true;
    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item){

        int id = item.getItemId();
        if(id == R.id.action_settings){
            return true;
        }
        else if(id == R.id.profil){
            Toast.makeText(getApplicationContext(),"Profil tıkladın", Toast.LENGTH_LONG).show();
        }
        else if(id == android.R.id.home){
            if (drawerLayout.isDrawerOpen(navList)) {
                drawerLayout.closeDrawer(navList);
            } else {
                drawerLayout.openDrawer(navList);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        loadSelection(i);
        drawerLayout.closeDrawer(navList);
    }
}


