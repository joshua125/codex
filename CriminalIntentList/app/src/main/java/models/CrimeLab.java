package models;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by Codex125 on 5/30/17.
 */

public class CrimeLab {

//CrimeLab.class will host our list of Crime objects
    private static CrimeLab singletonCrimeLab;

    private List<Crime> mCrimes;

    public static CrimeLab get(Context context){
        if (singletonCrimeLab == null){
            singletonCrimeLab = new CrimeLab(context);
        }
        return singletonCrimeLab;
    }

    private CrimeLab(Context context){
        mCrimes = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            Crime crime = new Crime();
            crime.setTitle("Crime #" + i);
            crime.setSolved(i % 2 == 0);
            mCrimes.add(crime);
        }
    }

    public List<Crime> getCrimes(){
        return mCrimes;
    }

    public Crime getCrime(UUID id){
        for (Crime crime : mCrimes){ //equivelant to each||do in Ruby
            if (crime.getID().equals(id)){
                return crime;
            }
        }
        return null;
    }
}
