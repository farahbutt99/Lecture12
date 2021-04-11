package com.example.lecture12_drawernavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;



public class MainActivity extends AppCompatActivity {
    DrawerLayout dl;
    ActionBarDrawerToggle t;
    NavigationView nv;
    Toolbar toolbar;

    @Override
    public void onBackPressed() {
        if (dl.isDrawerOpen(GravityCompat.START)) {
            dl.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(), "start", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "End", Toast.LENGTH_LONG).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dl = (DrawerLayout)findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);

        t = new ActionBarDrawerToggle(this, dl,toolbar,R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        dl.addDrawerListener(t);
        t.syncState();

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nv = (NavigationView)findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.nav_book:
                        Toast.makeText(getApplicationContext(), "Book is clicked", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(MainActivity.this, BookActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_return:
                        Toast.makeText(getApplicationContext(), "Return is clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_laptop:
                        Toast.makeText(getApplicationContext(), "Laptop is clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_voice:
                        Toast.makeText(getApplicationContext(), "Voice is clicked", Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_read_more:
                        Toast.makeText(getApplicationContext(), "reader is clicked", Toast.LENGTH_LONG).show();
                        break;
                    default:
                        return true;
                }
                return true;
            }
        });
    }
 /*   @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(t.onOptionsItemSelected(item))
            return true;

        return super.onOptionsItemSelected(item);
    }*/
}
