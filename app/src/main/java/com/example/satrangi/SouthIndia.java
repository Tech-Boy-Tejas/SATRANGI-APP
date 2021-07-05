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

import com.example.satrangi.ui.home.HomeFragment;

import java.sql.BatchUpdateException;

public class SouthIndia extends Fragment {

    private SouthIndiaViewModel mViewModel;

    public static SouthIndia newInstance() {
        return new SouthIndia();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.south_india_fragment, container, false);

        Button karnataka = (Button) rootView.findViewById(R.id.button7);
        Button tamilNadu = (Button) rootView.findViewById(R.id.button8);
        Button backbtn = (Button) rootView.findViewById(R.id.button18);

        karnataka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main,new Karnataka()
                );
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        tamilNadu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main,new TamilNadu()
                );
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main,new HomeFragment()
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
        mViewModel = new ViewModelProvider(this).get(SouthIndiaViewModel.class);
        // TODO: Use the ViewModel
    }

}