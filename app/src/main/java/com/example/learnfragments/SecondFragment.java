package com.example.learnfragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.io.Serializable;


public class SecondFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";

    private Person mParam1;

    public SecondFragment() {
        // Required empty public constructor
    }

    public static SecondFragment newInstance(Person person) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARAM1, person);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = (Person) getArguments().getSerializable(ARG_PARAM1);
        }
    }

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root =  inflater.inflate(R.layout.fragment_second, container, false);

        setHasOptionsMenu(true);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        Button btnCloseFragment = root.findViewById(R.id.btnCloseFragment);
        TextView tvFirstLastName = root.findViewById(R.id.tvFirstLastName);

        tvFirstLastName.setText(mParam1.getFirstName() + " " + mParam1.getLastName());

        btnCloseFragment.setOnClickListener(view -> {
            FragmentManager parentFragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = parentFragmentManager.beginTransaction();
            fragmentTransaction.remove(this);
            parentFragmentManager.popBackStack();
            fragmentTransaction.commit();
        });

        return root;

    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_plus,menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // TODO:
        return super.onOptionsItemSelected(item);
    }
}