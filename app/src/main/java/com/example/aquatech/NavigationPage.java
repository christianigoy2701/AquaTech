package com.example.aquatech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.aquatech.databinding.ActivityMainBinding;
import com.example.aquatech.databinding.ActivityNavigationPageBinding;

public class NavigationPage extends AppCompatActivity {

    ActivityNavigationPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNavigationPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new AHomePage());

        binding.bottomNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.homeButton:
                    replaceFragment(new AHomePage());
                    break;
                case R.id.searchButton:
                    replaceFragment(new ASearchPage());
                    break;
                case R.id.chatButton:
                    replaceFragment(new CreateConsumer());
                    break;
                case R.id.profileButton:
                    replaceFragment(new AProfilePage());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}