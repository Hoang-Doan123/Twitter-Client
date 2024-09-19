package com.example.tablayout;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingsFragment extends Fragment {

    public SettingsFragment() {
        // Required empty public constructor
    }

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Lấy các LinearLayout từ giao diện
        LinearLayout llFilter = view.findViewById(R.id.ll_filter);
        LinearLayout llOptions = view.findViewById(R.id.ll_options);

        ImageButton returnButton = (ImageButton) view.findViewById(R.id.button_return);
        returnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến trang bộ lọc
                Log.i("Test", "On click");
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new FilterFragment()); // Thay bằng Fragment bộ lọc tương ứng
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        TextView button = (TextView) view.findViewById(R.id.complete);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến trang bộ lọc
                Log.i("Test", "On click");
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new FilterFragment()); // Thay bằng Fragment bộ lọc tương ứng
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        // Xử lý sự kiện khi nhấn vào mục "Bộ lọc"
        llFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến trang bộ lọc
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new FilterFragment()); // Thay bằng Fragment bộ lọc tương ứng
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        // Xử lý sự kiện khi nhấn vào mục "Tùy chọn"
        llOptions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Chuyển đến trang tùy chọn
                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();
                transaction.replace(R.id.fragment_container, new OptionsFragment()); // Thay bằng Fragment tùy chọn tương ứng
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        return view;
    }
}
