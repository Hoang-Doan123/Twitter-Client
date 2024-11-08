package com.example.twitterclient.notification_section;

import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.twitterclient.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class NotificationSettingFragment extends Fragment {

    private View view;
    private FloatingActionButton addFab;
    private TextView completeTv;
    private ImageView arrowBackIcon;
    private Toolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_notification_setting, container, false);
        toolbar = getActivity().findViewById(R.id.tool_bar);
        addFab = getActivity().findViewById(R.id.add_fab);
        arrowBackIcon = view.findViewById(R.id.arrow_back_icon);
        completeTv = view.findViewById(R.id.complete_tv);

        toolbar.setVisibility(View.GONE);
        addFab.setVisibility(View.VISIBLE);

        arrowBackIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        completeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                requireActivity().getSupportFragmentManager().popBackStack();
            }
        });

        return view;
    }
}