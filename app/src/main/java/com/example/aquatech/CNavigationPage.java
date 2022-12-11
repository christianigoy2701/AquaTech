package com.example.aquatech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.aquatech.databinding.ActivityCnavigationPageBinding;

public class CNavigationPage extends AppCompatActivity {

    ActivityCnavigationPageBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCnavigationPageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new CHomePage());

        binding.bottomCNavigationView.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.homeButton:
                    replaceFragment(new CHomePage());
                    break;
                case R.id.chatButton:
                    replaceFragment(new CProfileEditPage());
                    break;
                case R.id.profileButton:
                    replaceFragment(new CChangePassword());
                    break;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }
}