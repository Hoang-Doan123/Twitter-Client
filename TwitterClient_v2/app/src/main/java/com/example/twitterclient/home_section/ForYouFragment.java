package com.example.twitterclient.home_section;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.twitterclient.APIService;
import com.example.twitterclient.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ForYouFragment extends Fragment {
    private static final String URL = "http://192.168.56.1:8000/api/posts";

    private View view;
    private TabLayout tabLayoutTop, tabLayoutBot;
    private FloatingActionButton addFab;

    private List<Post> list = new ArrayList<Post>();

    private Toolbar toolbar;
    private SwipeRefreshLayout swipeRefreshLayout;
    private PostAdapter postAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Retrofit retrofit = new Retrofit.Builder().baseUrl(URL)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        APIService apiService = retrofit.create(APIService.class);
//        fetchPosts(apiService);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_for_you, container, false);

        // toolbar = getActivity().findViewById(R.id.tool_bar);
        tabLayoutTop = getActivity().findViewById(R.id.home_tab_layout_top);
        tabLayoutBot = getActivity().findViewById(R.id.tab_layout_bot);

        swipeRefreshLayout = view.findViewById(R.id.swipe_refresh_layout_for_you);
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_for_you);
        addFab = getActivity().findViewById(R.id.add_fab);

        postAdapter = new PostAdapter();

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        RequestQueue requestQueue = Volley.newRequestQueue(requireActivity());

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new com.android.volley.Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject jsonObject = response.getJSONObject(i);
                                int id = jsonObject.getInt("id");
                                String user = jsonObject.getString("user");
                                String date = jsonObject.getString("date");
                                String text = jsonObject.getString("text");
                                int commentNum = jsonObject.getInt("commentNum");
                                int repostNum = jsonObject.getInt("repostNum");
                                int likesNum = jsonObject.getInt("likesNum");
                                Post newPost = new Post(user, date, text, commentNum, repostNum, likesNum);
                                list.add(newPost);
                            }
                        } catch (JSONException e) {
                            Log.e("Initialize Error", e.toString());
                        }
                    }
                },
                new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Response Error", error.toString());
                    }
                }
        );

        requestQueue.add(jsonArrayRequest);

        postAdapter.setData(getListPost());
        recyclerView.setAdapter(postAdapter);

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshData();
                swipeRefreshLayout.setRefreshing(false);
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    tabLayoutBot.setVisibility(View.INVISIBLE);
                    addFab.hide();
                } else {
                    tabLayoutBot.setVisibility(View.VISIBLE);
                    addFab.show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        return view;
    }

    private void refreshData() {
        List<Post> newData = getListPost();
        postAdapter.setData(newData);
        postAdapter.notifyDataSetChanged();
    }

    private List<Post> getListPost() {
        Log.i("List Post", list.toString());
        if (!list.isEmpty()) {

        }
        return list;
    }

    private void fetchPosts(APIService apiService) {
        Call<List<Post>> call = apiService.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Post> posts = response.body();
                    for (Post post : posts) {
                        Log.i("Post Info", "Title: " + post.getUserName() + ", Content: " + post.getPostTitle());
                    }
                } else {
                    Log.e("API Error", "Response Code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Log.e("API Error", "Error fetching posts", t);
            }
        });
    }
}