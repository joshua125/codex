package models;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.example.codex125.criminalintent.CrimeFragment;
import com.example.codex125.criminalintent.R;

/**
 * Created by Codex125 on 5/30/17.
 */

public abstract class SingleFragmentActivity extends FragmentActivity{

    protected abstract Fragment createFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        //FragmentManager allows us to add a fragment to an activity
        FragmentManager fragMan = getSupportFragmentManager();
        Fragment frag = fragMan.findFragmentById(R.id.fragment_container);

        if (frag == null){
            frag = createFragment();
            fragMan.beginTransaction().add(R.id.fragment_container, frag).commit();
        }

    }
}
