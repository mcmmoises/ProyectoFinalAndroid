package com.software.moisesc.proyfinalandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.software.moisesc.proyfinalandroid.adapter.PostAdapter;
import com.software.moisesc.proyfinalandroid.model.Post;
import com.software.moisesc.proyfinalandroid.network.RetrievePostsAsyncTask;


public class PostFragment extends Fragment {
    private ListView listView;
    private PostAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post, container, false);
        // Inflate the layout for this fragment
        listView = (ListView)view.findViewById(R.id.posts_list_view);
        adapter = new PostAdapter(getActivity());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Post p = adapter.getItem(position);

                Toast.makeText(getActivity(), p.getTitle(), Toast.LENGTH_LONG).show();
            }
        });

        RetrievePostsAsyncTask task = new RetrievePostsAsyncTask(this);
        task.execute();

        return view;
    }

    public PostAdapter getAdapter() {
        return adapter;
    }
}
