package com.example.lecture12_drawernavigation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    NavigationView navigationView;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle toggle;

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
            Toast.makeText(getApplicationContext(), "text", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "End", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView=findViewById(R.id.nav_view);
        drawerLayout =findViewById(R.id.drawer);

        toggle =new ActionBarDrawerToggle(this,drawerLayout,toolbar,1,2);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId())
                {
                    case R.id.nav_book:
                        Toast.makeText(getApplicationContext(),"Book is clicked",Toast.LENGTH_LONG).show();
                        Intent intent =new Intent(MainActivity.this,BookActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_return:
                        Toast.makeText(getApplicationContext(),"Return is clicked",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_laptop:
                        Toast.makeText(getApplicationContext(),"Laptop is clicked",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_voice:
                        Toast.makeText(getApplicationContext(),"Voice is clicked",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.nav_chrome_reader:
                        Toast.makeText(getApplicationContext(),"Chrome reader is clicked",Toast.LENGTH_LONG).show();
                        break;
                }
                return true;
            }
        });
    }
}