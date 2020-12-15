package com.skyproduct.example.materialdesignsevenlearn;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Toolbar toolbar = view.findViewById(R.id.toolbar_main);
        toolbar.setNavigationIcon(R.drawable.ic_baseline_menu_24);
        AppCompatActivity appCompatActivity = (AppCompatActivity) getActivity();
        appCompatActivity.setSupportActionBar(toolbar);
        DrawerLayout drawerLayout = view.findViewById(R.id.drawerLayout_main);
        ActionBarDrawerToggle drawerToggle = new ActionBarDrawerToggle(getActivity(),
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close);
        drawerLayout.addDrawerListener(drawerToggle);


        MaterialCardView cardView = view.findViewById(R.id.card_view_main);
        cardView.setOnClickListener(v -> {
            FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.frame_main_container, new DetailFragment())
                    .addToBackStack(null)
                    .commit();
        });

        FloatingActionButton fab = view.findViewById(R.id.fab_main);
        fab.setOnClickListener(v -> {
                    Snackbar.make(getView(), "Material Design SnackBar", Snackbar.LENGTH_INDEFINITE)
                            .setAction("Retry", v1 -> { })
                            .show();
                }
        );

       /* MaterialCardView cardView = view.findViewById(R.id.card_view_main);
        cardView.setChecked(true);
        cardView.setOnClickListener(v -> cardView.setChecked(!cardView.isChecked()));*/
    }
}
