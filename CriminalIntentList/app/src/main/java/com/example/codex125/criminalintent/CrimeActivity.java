package com.example.codex125.criminalintent;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.os.Bundle;

import java.util.UUID;

import models.SingleFragmentActivity;

public class CrimeActivity extends SingleFragmentActivity {

    private static final String EXTRA_CRIME_ID = "com.criminalIntent.crime_id";

    public static Intent newIntent(Context packageContext, UUID crimeId){
        Intent intent = new Intent(packageContext, CrimeActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }

    @Override
    protected Fragment createFragment() {

        //return new CrimeFragment();

        UUID crimeId = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        return CrimeFragment.newInstance(crimeId);
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
