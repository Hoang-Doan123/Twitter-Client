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

public class EmailPostAdapter extends RecyclerView.Adapter<EmailPostAdapter.EmailPostViewHolder> {
    private List<EmailPost> listEmailPost;

    public void setData(List<EmailPost> list) {
        this.listEmailPost = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public EmailPostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.email_post_item, parent, false);
        return new EmailPostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmailPostAdapter.EmailPostViewHolder holder, int position) {
        EmailPost emailPost = listEmailPost.get(position);
        if (emailPost == null) {
            return;
        }
        holder.emailUserAvatar.setImageResource(emailPost.getEmailUserAvatar());
        holder.emailUserName.setText(emailPost.getEmailUserName());
        holder.emailUserTag.setText(emailPost.getEmailUserTag());
        holder.emailPostDate.setText(emailPost.getEmailPostDate());
        holder.emailPostContent.setText(emailPost.getEmailPostContent());
    }

    @Override
    public int getItemCount() {
        if (listEmailPost != null) {
            return listEmailPost.size();
        }
        return 0;
    }

    public class EmailPostViewHolder extends RecyclerView.ViewHolder {

        private ImageView emailUserAvatar;
        private TextView emailUserName, emailUserTag, emailPostDate, emailPostContent;

        public EmailPostViewHolder(@NotNull View itemView) {
            super(itemView);
            emailUserAvatar = itemView.findViewById(R.id.email_user_avatar);
            emailUserName = itemView.findViewById(R.id.email_user_name);
            emailUserTag = itemView.findViewById(R.id.email_user_tag);
            emailPostDate = itemView.findViewById(R.id.email_post_date);
            emailPostContent = itemView.findViewById(R.id.email_post_content);

        }
    }
}
