package com.example.fragments;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.os.PersistableBundle;

public class MainActivity extends AppCompatActivity implements FragmentA.connection {

//    private static final String Fragment_b = "FragmentB";
//    private static final String Fragment_A = "FragmentA";
    FragmentA fragmentA;
    FragmentB fragmentB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // add fragments
        FragmentManager fragmentManager = getSupportFragmentManager();


        if (savedInstanceState==null)

        {  if (fragmentB == null) {
            fragmentB = new FragmentB();
            fragmentManager.beginTransaction().add(R.id.fragment_b, fragmentB, fragmentB.getTag()).commit();
        }


        if (fragmentA == null) {
            fragmentA = new FragmentA();
            fragmentManager.beginTransaction().add(R.id.fragment_a, fragmentA, fragmentA.getTag()).commit();
        }


    }
    }


    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
    }

    @Override
    public void sendText(String text) {


        fragmentB.modifyString(text);
    }
}
