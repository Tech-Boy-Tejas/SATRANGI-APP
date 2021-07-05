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

public class TamilNadu extends Fragment {

    private TamilNaduViewModel mViewModel;

    public static TamilNadu newInstance() {
        return new TamilNadu();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.tamil_nadu_fragment, container, false);
        Button backbtn = (Button) rootView.findViewById(R.id.button90);

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
        mViewModel = new ViewModelProvider(this).get(TamilNaduViewModel.class);
        // TODO: Use the ViewModel
    }

}