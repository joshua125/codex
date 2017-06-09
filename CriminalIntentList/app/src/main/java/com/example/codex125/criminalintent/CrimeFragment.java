package com.example.codex125.criminalintent;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

import models.Crime;
import models.CrimeLab;

import static models.CrimeLab.get;

public class CrimeFragment extends Fragment {

    private static final String ARG_CRIME_ID = "crime_ud";

    private Crime mCrime;
    private EditText mTitleField;
    //private Button mSendButton;
    //private TextView mTextView;
    private Button mDateButton;
    private CheckBox mSolvedCheckBox;

    public static CrimeFragment newInstance(UUID crimeId){
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);
        //passing data via fragment arguments between crimeFragment and CrimeActvity
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //mCrime = new Crime();
        UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);

        mCrime = CrimeLab.get(getActivity()).getCrime(crimeId);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View v = inflater.inflate(R.layout.crime_fragment, container, false);


        mTitleField = (EditText)v.findViewById(R.id.crime_title);
        //Listen to see if there are any changes in the Edittext input
        mTitleField.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after){
                //intentionally left blank
            }
            // take in a charsequence and update our mCrimetitle which will be displayed in fragment
            @Override
            public void onTextChanged( CharSequence s, int start, int before, int count){
                mCrime.setTitle(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s){
                //intentionally left blank
            }
        });

        mDateButton = (Button)v.findViewById(R.id.crime_date);
        mDateButton.setText(mCrime.getDate().toString());

        mDateButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //we'll add functionality later
            }
        });

        mDateButton.setEnabled(false);

        mSolvedCheckBox = (CheckBox)v.findViewById(R.id.crime_solved);
        mSolvedCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //set crime is solved
                mCrime.setSolved(isChecked);
            }
        });

        return v;
    }

}
