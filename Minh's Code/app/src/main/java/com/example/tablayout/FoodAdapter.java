package com.example.tablayout;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHodel> {

    private List<Food> mListFood;

    public FoodAdapter(List<Food> mListFood) {
        this.mListFood = mListFood;
    }

    @NonNull
    @Override
    public FoodViewHodel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food,parent,false);
        return new FoodViewHodel(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FoodViewHodel holder, int position) {
        Food food= mListFood.get(position);
        if (food == null){
            return;
        }

        holder.imgFood.setImageResource(food.getImage());

    }

    @Override
    public int getItemCount() {
        if (mListFood != null ){
            return mListFood.size();
        }
        return 0;
    }

    public class FoodViewHodel extends RecyclerView.ViewHolder{

        private ImageView imgFood;


        public FoodViewHodel(@NonNull View itemView) {
            super(itemView);

            imgFood = itemView.findViewById(R.id.img_food);
        }
    }
}
