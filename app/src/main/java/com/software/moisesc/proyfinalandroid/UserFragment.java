package com.software.moisesc.proyfinalandroid;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.software.moisesc.proyfinalandroid.adapter.UserAdapter;
import com.software.moisesc.proyfinalandroid.model.User;
import com.software.moisesc.proyfinalandroid.network.RetrieveUsersAsyncTask;


public class UserFragment extends Fragment {
    private ListView listView;
    private UserAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        // Inflate the layout for this fragment
        listView = (ListView)view.findViewById(R.id.users_list_view);
        adapter = new UserAdapter(getActivity());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                User p = adapter.getItem(position);

                Toast.makeText(getActivity(), p.getUsername(), Toast.LENGTH_LONG).show();
            }
        });

        RetrieveUsersAsyncTask task = new RetrieveUsersAsyncTask(this);
        task.execute();

        return view;
    }

    public UserAdapter getAdapter() {
        return adapter;
    }
}
