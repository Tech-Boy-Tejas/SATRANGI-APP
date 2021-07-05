package com.example.satrangi.ui.anthem;

import androidx.lifecycle.ViewModelProvider;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.MediaController;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.satrangi.R;

public class National_anthem extends Fragment {

    private NationalAnthemViewModel mViewModel;

    MediaPlayer mediaPlayer = new MediaPlayer();
    VideoView videoView;
    MediaController mediaController;
    TextView textView;

    int stopPositionforVideo;

    public static National_anthem newInstance() {
        return new National_anthem();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.national_anthem_fragment, container, false);

        Button button1 = (Button) rootView.findViewById(R.id.button1);
        videoView = (VideoView) rootView.findViewById(R.id.videoView);
        mediaController = new MediaController(getActivity());

        mediaController.setAnchorView(videoView);
        mediaController.setMediaPlayer(videoView);
        videoView.setMediaController(mediaController);

        videoView.setVideoPath("android.resource://com.example.satrangi/" + R.raw.national_anthem_video);
        videoView.requestFocus();

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer mp) {

                mp.setVolume((float)0.3, (float)0.3);
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button1)
            {
                videoView.seekTo(stopPositionforVideo);
                videoView.start();

            }
        });

        Button button2 = (Button) rootView.findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View button2)
            {
                stopPositionforVideo = videoView.getCurrentPosition();
                videoView.pause();
            }
        });

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(NationalAnthemViewModel.class);
        // TODO: Use the ViewModel
    }

}