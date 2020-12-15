package com.skyproduct.example.materialdesignsevenlearn;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigation_main);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                switch (item.getItemId()) {
                    case R.id.menuItem_home:
                        transaction.replace(R.id.frame_main_container, new MainFragment())
                                .commit();
                        return true;
                    case R.id.menuItem_recents:
                        transaction.replace(R.id.frame_main_container, new RecentsFragment())
                                .commit();
                        return true;
                    case R.id.menuItem_nearby:
                        transaction.replace(R.id.frame_main_container, new NearByFragment())
                                .commit();
                        return true;
                }
                return false;
            }
        });
        bottomNavigationView.setSelectedItemId(R.id.menuItem_home);

        bottomNavigationView.setOnNavigationItemReselectedListener(v -> {});
    }

}