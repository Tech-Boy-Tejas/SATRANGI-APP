package com.example.satrangi;

import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Karnataka extends Fragment {

    private KarnatakaViewModel mViewModel;

    public static Karnataka newInstance() {
        return new Karnataka();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.karnataka_fragment, container, false);
        Button backbtn = (Button) rootView.findViewById(R.id.button91);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main,new SouthIndia()
                );
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(KarnatakaViewModel.class);
        // TODO: Use the ViewModel
    }

}