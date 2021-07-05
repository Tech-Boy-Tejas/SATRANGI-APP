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
import android.widget.TextView;

import com.example.satrangi.ui.home.HomeFragment;

import org.w3c.dom.Text;

public class NorthIndia extends Fragment {

    private NorthIndiaViewModel mViewModel;

    public static NorthIndia newInstance() {
        return new NorthIndia();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.north_india_fragment1, container, false);
        getActivity().setTitle("SATRANGI - NORTH INDIA");

        Button jandk = (Button) rootView.findViewById(R.id.button1);
        Button hp = (Button) rootView.findViewById(R.id.button5);
        Button backbtn = (Button) rootView.findViewById(R.id.button15);

        jandk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main,new JandK()
                );
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main,new HP()
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
        mViewModel = new ViewModelProvider(this).get(NorthIndiaViewModel.class);
        // TODO: Use the ViewModel
    }

}