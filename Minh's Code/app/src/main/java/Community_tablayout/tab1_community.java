package Community_tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tablayout.CommunitiesUser;
import com.example.tablayout.CommunitiesUserAdapter;
import com.example.tablayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tab1_community#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tab1_community extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView rcvuser;
    private CommunitiesUserAdapter communitiesUserAdapter;

    public tab1_community() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment tab1_community.
     */
    // TODO: Rename and change types and number of parameters
    public static tab1_community newInstance(String param1, String param2) {
        tab1_community fragment = new tab1_community();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab1_community, container, false);

        // Initialize RecyclerView and its adapter here
        rcvuser = view.findViewById(R.id.rcv_communities_user);
        communitiesUserAdapter = new CommunitiesUserAdapter(getContext());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rcvuser.setLayoutManager(linearLayoutManager);
        communitiesUserAdapter.setData(getListCommunitiesUser());
        rcvuser.setAdapter(communitiesUserAdapter);

        return view;
    }

    private List<CommunitiesUser> getListCommunitiesUser(){
        List<CommunitiesUser> list = new ArrayList<>();
        list.add(new CommunitiesUser(R.drawable.avatar_5, "user name 1", "10M Members", "Technology"));
        list.add(new CommunitiesUser(R.drawable.avatar_3, "user name 2", "5M Members", "Health"));
        list.add(new CommunitiesUser(R.drawable.avatar_6, "user name 3", "1M Members", "Education"));
        list.add(new CommunitiesUser(R.drawable.avatar_7, "user name 4", "500K Members", "Art"));
        list.add(new CommunitiesUser(R.drawable.avatar_9, "user name 5", "100K Members", "Travel"));
        return list;
    }
}
