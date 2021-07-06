package com.example.satrangi.ui.home;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.satrangi.EastIndia;
import com.example.satrangi.NorthIndia;
import com.example.satrangi.R;
import com.example.satrangi.SouthIndia;
import com.example.satrangi.WestIndia;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

import static android.content.Context.MODE_PRIVATE;
import static android.content.Context.NOTIFICATION_SERVICE;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;

    MediaPlayer mediaPlayer;
    VideoView videoView1,videoView2;
    EditText editText;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        Button btn_north = (Button) rootView.findViewById(R.id.button);
        Button btn_west = (Button) rootView.findViewById(R.id.button1);
        Button btn_east = (Button) rootView.findViewById(R.id.button2);
        Button btn_south = (Button) rootView.findViewById(R.id.button3);

        Button save_btn = (Button) rootView.findViewById(R.id.button19);
        EditText editText = (EditText) rootView.findViewById(R.id.edittxt);

        TextView textView = (TextView) rootView.findViewById(R.id.textView81);

        videoView1 = (VideoView) rootView.findViewById(R.id.videoView1);
        videoView2 = (VideoView) rootView.findViewById(R.id.videoView2);

        videoView1.setVideoPath("android.resource://com.example.satrangi/" + R.raw.satrangi_video_forhome);
        videoView1.requestFocus();

        videoView2.setVideoPath("android.resource://com.example.satrangi/" + R.raw.purpose_video_mp4);
        videoView2.requestFocus();

        videoView1.start();
        videoView2.start();

        String fact = "";
        int random_number = (int)(10 * (Math.random()));

        switch(random_number){
            case 1:
                fact = "The name kathak comes from the Sanskrit word “katha,” which means story, and this expressive dance form more than lives up to its name.";
                break;
            case 2:
                fact = "Bhangra was started by farmers as a folk dance to celebrate the harvest season. But it eventually evolved in the 20th century, incorporating elements of western music into traditional dances to form a mixture of both worlds.";
                break;
            case 3:
                fact = "Statues of a Jain saint, Bahubali, can be seen throughout the southern India state of Karnataka.\n" +
                        "\n" +
                        "Bahubali is known for having meditated in a standing position for one year before attaining enlightenment. In these statues he is often seen standing upright, with arms at his sides.";
                break;
            case 4:
                fact = "Turmeric has long been a staple in Indian cuisine. This spice comes from a flowering plant and is used in numerous ways. Cooking is the most well-known application, with food taking on a vivid yellow color when turmeric is used.";
                break;
            case 5:
                fact = "One nickname for Jaipur is “the Pink City.” You’ll see why when you notice the vast number of pink buildings you will pass by during any of the various Rajasthan tours that are available.";
                break;
            case 6:
                fact = "Dandiya, another local form of dance, has integrated with garba as well to create a lively dance experience. This style is performed with two wooden sticks amongst partners and large groups, who hit the sticks in a rhythmic pattern.";
                break;
            case 7:
                fact = "Assam’s tea gardens (a.k.a. tea plantations) are celebrated at the Assam Tea Festival every November. There, visitors can view the various tea gardens and taste-test different types of tea in the Guwahati Tea Auction Centre.";
                break;
            case 8:
                fact = "Arunachal Pradesh, which is located in the eastern part of the country, is home to a wide variety of languages concentrated in a fairly small area.\n" +
                        "\n" +
                        "While the widely-spoken languages like Hindi and Bengali are present, many of those spoken in Arunachal Pradesh are indigenous dialects, with some being more similar to one another than others.";
                break;
            case 9:
                fact = "The Bastar region of Chhattisgarh is one place where many unique indigenous tribes are situated, with the demographics of the region being about 30% tribal groups.";
                break;
            case 10:
                fact = "Chhattisgarh plays a major role in this Hindu god’s life because it is where he and his wife, Sita, lived there for 10 years. Along with Lord Rama’s brother, Lakshman, they lived in the Bastar region after they were exiled to the forest by his father, King Dasharatha.";
                break;
            default:
                break;
        }

        for(int i = 0;i < 2; i++){
            Toast.makeText(requireActivity(),fact,Toast.LENGTH_LONG).show();
        }


        videoView1.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        videoView2.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });

        btn_north.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main,new NorthIndia()
                );
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        btn_west.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main,new WestIndia()
                );
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        btn_east.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction =  fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.nav_host_fragment_content_main,new EastIndia()
                );
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });
        btn_south.setOnClickListener(new View.OnClickListener() {
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

        save_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText.getText().toString();

                SharedPreferences shrd = getActivity().getSharedPreferences("DataOfUser", MODE_PRIVATE);
                SharedPreferences.Editor editor = shrd.edit();

                editor.putString("dataofuser",name);
                editor.apply();

                textView.setVisibility(View.VISIBLE);
                textView.setText("Hello " + name + ", Welcome to Satrangi");
                save_btn.setVisibility(View.INVISIBLE);
                editText.setVisibility(View.INVISIBLE);

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
                    builder.setContentText("Your name has been succesfuly saved, " + name);
                }
                else{
                    builder.setContentText("You have not entered anything please try again");
                }
                builder.setSmallIcon(R.drawable.noti_icon);

                notificationManager.notify(10,builder.build());

            }
        });

        SharedPreferences getData = getActivity().getSharedPreferences("DataOfUser",MODE_PRIVATE);
        String final_name = getData.getString("dataofuser","");

        if(final_name != ""){
            save_btn.setVisibility(View.INVISIBLE);
            editText.setVisibility(View.INVISIBLE);
            textView.setVisibility(View.VISIBLE);
        }
        else{
            save_btn.setVisibility(View.VISIBLE);
            editText.setVisibility(View.VISIBLE);
            textView.setVisibility(View.INVISIBLE);
        }
        textView.setText("Hello " + final_name + ", Welcome to Satrangi");

        return rootView;
    }




    @Override
    public void onResume(){
        super.onResume();
        videoView1.start();
        videoView2.start();

        videoView1.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        videoView2.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        // TODO: Use the ViewModel
    }
}