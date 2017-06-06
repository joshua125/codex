package com.example.codex125.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import models.SingleFragmentActivity;

public class CrimeActivity extends SingleFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new CrimeFragment();
    }
    //We abstracted out this code to SingleFragmentActivity.class
    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        //FragmentManager allows us to add a fragment to an activity
        FragmentManager fragMan = getSupportFragmentManager();
        Fragment frag = fragMan.findFragmentById(R.id.fragment_container);

        if (frag == null){
            frag = new CrimeFragment();
            fragMan.beginTransaction().add(R.id.fragment_container, frag).commit();
        }

    }*/



}
