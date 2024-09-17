package com.example.tablayout;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CommunitiesUserAdapter extends  RecyclerView.Adapter<CommunitiesUserAdapter.UserViewHoder> {

        private Context mContext;
        private List<CommunitiesUser>  mListUser;

    public CommunitiesUserAdapter(Context mContext) {
        this.mContext = mContext;
    }

        public void setData(List<CommunitiesUser> List){
                this.mListUser = List;
                notifyDataSetChanged();
        }

    @NonNull
    @Override
    public UserViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.communities_item_user,parent,false);
        return new UserViewHoder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHoder holder, int position) {
        CommunitiesUser  communitiesUser= mListUser.get(position);
        if (communitiesUser == null){
            return;
        }

        holder.imgUser.setImageResource(communitiesUser.getResourceId());
        holder.tvName.setText(communitiesUser.getName());
        holder.members.setText(communitiesUser.getMembers());
        holder.type.setText(communitiesUser.getType());
    }

    @Override
    public int getItemCount() {
        if (mListUser != null){
            return  mListUser.size();
        }
        return 0;
    }

    public class  UserViewHoder extends RecyclerView.ViewHolder{

         private ImageView imgUser;
         private TextView tvName;
         private TextView members;
         private TextView type;

         public UserViewHoder(@NonNull View itemView) {
             super(itemView);

             imgUser = itemView.findViewById(R.id.img_communities_user);
             tvName = itemView.findViewById(R.id.name_user);
             members = itemView.findViewById(R.id.members_user);
             type = itemView.findViewById(R.id.type_user);
         }
     }
}
