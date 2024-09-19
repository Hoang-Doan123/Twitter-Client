package Community_tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tablayout.Explore;
import com.example.tablayout.ExploreAdapter;
import com.example.tablayout.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link tab2_community#newInstance} factory method to
 * create an instance of this fragment.
 */
public class tab2_community extends Fragment implements View.OnClickListener{

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;
    private RecyclerView rcvFood;
    private Button btnFood,btnAnimal,btnTech,btn_art,btn_sports,btn_gaming;
    private LinearLayoutManager linearLayoutManager;


    public tab2_community() {
        // Required empty public constructor
    }


    public static tab2_community newInstance(String param1, String param2) {
        tab2_community fragment = new tab2_community();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab2_community, container, false);

        // Use 'view' to find the views in the fragment layout
        btnFood = view.findViewById(R.id.btn_food);
        btnAnimal = view.findViewById(R.id.btn_animal);
        btnTech = view.findViewById(R.id.btn_tech);
        btn_art = view.findViewById(R.id.btn_art);
        btn_sports = view.findViewById(R.id.btn_sports);
        btn_gaming = view.findViewById(R.id.btn_gaming);

        rcvFood = view.findViewById(R.id.rcv_explore);

        linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rcvFood.setLayoutManager(linearLayoutManager);

        ExploreAdapter adapter = new ExploreAdapter(getListFood());
        rcvFood.setAdapter(adapter);

        btnFood.setOnClickListener(this);
        btnAnimal.setOnClickListener(this);
        btnTech.setOnClickListener(this);
        btn_art.setOnClickListener(this);
        btn_gaming.setOnClickListener(this);
        btn_sports.setOnClickListener(this);

        return view;
    }


    private List<Explore> getListFood() {
        List<Explore> list= new ArrayList<>();
        list.add(new Explore(R.drawable.food1, Explore.TYPE_food));
        list.add(new Explore(R.drawable.food, Explore.TYPE_food));
        list.add(new Explore(R.drawable.food2, Explore.TYPE_food));
        list.add(new Explore(R.drawable.food3, Explore.TYPE_food));
        list.add(new Explore(R.drawable.food4, Explore.TYPE_food));
        list.add(new Explore(R.drawable.food5, Explore.TYPE_food));
        list.add(new Explore(R.drawable.food6, Explore.TYPE_food));
        list.add(new Explore(R.drawable.food7, Explore.TYPE_food));
        list.add(new Explore(R.drawable.food8, Explore.TYPE_food));




        list.add(new Explore(R.drawable.animal1, Explore.TYPE_animal));
        list.add(new Explore(R.drawable.animal2, Explore.TYPE_animal));
        list.add(new Explore(R.drawable.animal3, Explore.TYPE_animal));
        list.add(new Explore(R.drawable.animal4, Explore.TYPE_animal));
        list.add(new Explore(R.drawable.animal5, Explore.TYPE_animal));
        list.add(new Explore(R.drawable.animal6, Explore.TYPE_animal));
        list.add(new Explore(R.drawable.animal7, Explore.TYPE_animal));
        list.add(new Explore(R.drawable.animal, Explore.TYPE_animal));
        list.add(new Explore(R.drawable.animal8, Explore.TYPE_animal));
        list.add(new Explore(R.drawable.animal9, Explore.TYPE_animal));



        list.add(new Explore(R.drawable.tech1, Explore.TYPE_tech));
        list.add(new Explore(R.drawable.tech9, Explore.TYPE_tech));
        list.add(new Explore(R.drawable.tech2, Explore.TYPE_tech));
        list.add(new Explore(R.drawable.tech3, Explore.TYPE_tech));
        list.add(new Explore(R.drawable.tech4, Explore.TYPE_tech));
        list.add(new Explore(R.drawable.tech5, Explore.TYPE_tech));
        list.add(new Explore(R.drawable.tech6, Explore.TYPE_tech));
        list.add(new Explore(R.drawable.tech7, Explore.TYPE_tech));
        list.add(new Explore(R.drawable.tech10, Explore.TYPE_tech));



        list.add(new Explore(R.drawable.art1, Explore.TYPE_art));
        list.add(new Explore(R.drawable.art, Explore.TYPE_art));
        list.add(new Explore(R.drawable.art2, Explore.TYPE_art));
        list.add(new Explore(R.drawable.art4, Explore.TYPE_art));
        list.add(new Explore(R.drawable.art5, Explore.TYPE_art));
        list.add(new Explore(R.drawable.art6, Explore.TYPE_art));
        list.add(new Explore(R.drawable.art7, Explore.TYPE_art));
        list.add(new Explore(R.drawable.art8, Explore.TYPE_art));
        list.add(new Explore(R.drawable.art9, Explore.TYPE_art));




        list.add(new Explore(R.drawable.sports1, Explore.TYPE_sports));
        list.add(new Explore(R.drawable.sports2, Explore.TYPE_sports));
        list.add(new Explore(R.drawable.sports3, Explore.TYPE_sports));
        list.add(new Explore(R.drawable.sports4, Explore.TYPE_sports));
        list.add(new Explore(R.drawable.sports5, Explore.TYPE_sports));
        list.add(new Explore(R.drawable.sports6, Explore.TYPE_sports));
        list.add(new Explore(R.drawable.sports7, Explore.TYPE_sports));
        list.add(new Explore(R.drawable.sports8, Explore.TYPE_sports));
        list.add(new Explore(R.drawable.sports9, Explore.TYPE_sports));



        list.add(new Explore(R.drawable.game,  Explore.TYPE_gaming));
        list.add(new Explore(R.drawable.game1, Explore.TYPE_gaming));
        list.add(new Explore(R.drawable.game2, Explore.TYPE_gaming));
        list.add(new Explore(R.drawable.game3, Explore.TYPE_gaming));
        list.add(new Explore(R.drawable.game4, Explore.TYPE_gaming));
        list.add(new Explore(R.drawable.game5, Explore.TYPE_gaming));
        list.add(new Explore(R.drawable.game6, Explore.TYPE_gaming));
        list.add(new Explore(R.drawable.game7, Explore.TYPE_gaming));
        list.add(new Explore(R.drawable.game8, Explore.TYPE_gaming));




        return list;

    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_food) {
            scrollToItem(0);
        } else if (id == R.id.btn_animal) {
            scrollToItem(9);
        } else if (id == R.id.btn_tech) {
            scrollToItem(19);
        } else if (id == R.id.btn_art) {
            scrollToItem(28);
        } else if (id == R.id.btn_sports) {
            scrollToItem(37);
        } else if (id == R.id.btn_gaming) {
            scrollToItem(46);
        }
    }

    private void scrollToItem(int index) {
        if (linearLayoutManager == null){
            return;
        }
        linearLayoutManager.scrollToPositionWithOffset(index,0);
    }
}


