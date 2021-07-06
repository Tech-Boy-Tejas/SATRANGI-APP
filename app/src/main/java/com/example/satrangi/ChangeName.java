package com.example.satrangi;

import androidx.core.app.NotificationCompat;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.satrangi.ui.home.HomeFragment;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Context.NOTIFICATION_SERVICE;

public class ChangeName extends Fragment {

    private ChangeNameViewModel mViewModel;

    public static ChangeName newInstance() {
        return new ChangeName();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView =  inflater.inflate(R.layout.change_name_fragment, container, false);

        Button backbtn = (Button) rootView.findViewById(R.id.button9);
        Button editnamebtn = (Button) rootView.findViewById(R.id.button6);

        EditText editText = (EditText) rootView.findViewById(R.id.editname);

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

        editnamebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();

                SharedPreferences shrd = getActivity().getSharedPreferences("DataOfUser", MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();

                editor.putString("dataofuser",name);
                editor.apply();

                NotificationManager notificationManager = (NotificationManager) requireActivity().getSystemService(NOTIFICATION_SERVICE);
                NotificationCompat.Builder builder = new NotificationCompat.Builder(requireActivity(),"Notifications");

                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel("Notifications","Notify",NotificationManager.IMPORTANCE_HIGH);
                    notificationChannel.enableLights(true);
                    notificationChannel.setName("Notification Manager");
                    notificationManager.createNotificationChannel(notificationChannel);
                }

                builder.setContentTitle("SATRANGI");


                if(name != ""){
                    builder.setContentText("Your name has been succesfully changed Thank You, " + name);
                }
                else{
                    builder.setContentText("You have not entered anything please try again user");
                }
                builder.setSmallIcon(R.drawable.noti_icon);

                notificationManager.notify(10,builder.build());


                Toast.makeText(requireActivity(),"It's done" + name,Toast.LENGTH_SHORT);
            }

            SharedPreferences getData = getActivity().getSharedPreferences("Data_User",MODE_PRIVATE);
            String final_name = getData.getString("data_user","");
        });
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(ChangeNameViewModel.class);
        // TODO: Use the ViewModel
    }

}