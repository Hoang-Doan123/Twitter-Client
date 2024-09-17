package Community_tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tablayout.Food;
import com.example.tablayout.FoodAdapter;
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

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView rcvFood;
    private Button btnFood,btnAnimal,btnTech;
    private LinearLayoutManager linearLayoutManager;

    public tab2_community() {
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
    public static tab2_community newInstance(String param1, String param2) {
        tab2_community fragment = new tab2_community();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
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

        rcvFood = view.findViewById(R.id.rcv_explore);

        linearLayoutManager = new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false);
        rcvFood.setLayoutManager(linearLayoutManager);

        FoodAdapter adapter = new FoodAdapter(getListFood());
        rcvFood.setAdapter(adapter);

        btnFood.setOnClickListener(this);
        btnAnimal.setOnClickListener(this);
        btnTech.setOnClickListener(this);

        return view;
    }


    private List<Food> getListFood() {
        List<Food> list= new ArrayList<>();
        list.add(new Food(R.drawable.food1,Food.TYPE_food));
        list.add(new Food(R.drawable.food1,Food.TYPE_food));
        list.add(new Food(R.drawable.food1,Food.TYPE_food));
        list.add(new Food(R.drawable.food1,Food.TYPE_food));
        list.add(new Food(R.drawable.food1,Food.TYPE_food));
        list.add(new Food(R.drawable.food1,Food.TYPE_food));
        list.add(new Food(R.drawable.food1,Food.TYPE_food));
        list.add(new Food(R.drawable.food1,Food.TYPE_food));
        list.add(new Food(R.drawable.food1,Food.TYPE_food));
        list.add(new Food(R.drawable.food1,Food.TYPE_food));



        list.add(new Food(R.drawable.animal1,Food.TYPE_animal));
        list.add(new Food(R.drawable.animal1,Food.TYPE_animal));
        list.add(new Food(R.drawable.animal1,Food.TYPE_animal));
        list.add(new Food(R.drawable.animal1,Food.TYPE_animal));
        list.add(new Food(R.drawable.animal1,Food.TYPE_animal));
        list.add(new Food(R.drawable.animal1,Food.TYPE_animal));
        list.add(new Food(R.drawable.animal1,Food.TYPE_animal));
        list.add(new Food(R.drawable.animal1,Food.TYPE_animal));
        list.add(new Food(R.drawable.animal1,Food.TYPE_animal));
        list.add(new Food(R.drawable.animal1,Food.TYPE_animal));



        list.add(new Food(R.drawable.tech1,Food.TYPE_tech));
        list.add(new Food(R.drawable.tech1,Food.TYPE_tech));
        list.add(new Food(R.drawable.tech1,Food.TYPE_tech));
        list.add(new Food(R.drawable.tech1,Food.TYPE_tech));
        list.add(new Food(R.drawable.tech1,Food.TYPE_tech));
        list.add(new Food(R.drawable.tech1,Food.TYPE_tech));
        list.add(new Food(R.drawable.tech1,Food.TYPE_tech));
        list.add(new Food(R.drawable.tech1,Food.TYPE_tech));
        list.add(new Food(R.drawable.tech1,Food.TYPE_tech));
        list.add(new Food(R.drawable.tech1,Food.TYPE_tech));
        list.add(new Food(R.drawable.tech1,Food.TYPE_tech));

        return list;

    }

    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_food) {
            scrollToItem(0);
        } else if (id == R.id.btn_animal) {
            scrollToItem(10);
        } else if (id == R.id.btn_tech) {
            scrollToItem(20);
        }
    }

    private void scrollToItem(int index) {
        if (linearLayoutManager == null){
            return;
        }
        linearLayoutManager.scrollToPositionWithOffset(index,0);
    }
}