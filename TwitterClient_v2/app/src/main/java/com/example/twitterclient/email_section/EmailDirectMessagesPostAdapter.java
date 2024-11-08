package com.example.twitterclient.email_section;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.twitterclient.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class EmailDirectMessagesPostAdapter extends RecyclerView.Adapter<EmailDirectMessagesPostAdapter.EmailDirectMessagesPostViewHolder> {
    private List<EmailDirectMessagesPost> listEmailDirectMessagesPost;

    public void setData(List<EmailDirectMessagesPost> list) {
        this.listEmailDirectMessagesPost = list;
        notifyDataSetChanged();
    }

    @NotNull
    @Override
    public EmailDirectMessagesPostViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_direct_messages_post_item, parent, false);
        return new EmailDirectMessagesPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull EmailDirectMessagesPostAdapter.EmailDirectMessagesPostViewHolder holder, int position) {
        EmailDirectMessagesPost emailDirectMessagesPost = listEmailDirectMessagesPost.get(position);
        if(emailDirectMessagesPost == null) {
            return;
        }
        holder.emailDirectMessUserAvatar.setImageResource(emailDirectMessagesPost.getEmailDirectMessUserAvatar());
        holder.emailDirectMessUserName.setText(emailDirectMessagesPost.getEmailDirectMessUserName());
        holder.emailDirectMessPostContent.setText(emailDirectMessagesPost.getEmailDirectMessPostContent());
    }

    @Override
    public int getItemCount() {
        if (listEmailDirectMessagesPost != null) {
            return listEmailDirectMessagesPost.size();
        }
        return 0;
    }

    public class EmailDirectMessagesPostViewHolder extends RecyclerView.ViewHolder {
        private ImageView emailDirectMessUserAvatar;
        private TextView emailDirectMessUserName, emailDirectMessPostContent;

        public EmailDirectMessagesPostViewHolder(@NotNull View itemView) {
            super(itemView);
            emailDirectMessUserAvatar = itemView.findViewById(R.id.email_direct_mess_user_avatar);
            emailDirectMessUserName = itemView.findViewById(R.id.email_direct_mess_user_name);
            emailDirectMessPostContent = itemView.findViewById(R.id.email_direct_mess_post_content);
        }
    }
}
