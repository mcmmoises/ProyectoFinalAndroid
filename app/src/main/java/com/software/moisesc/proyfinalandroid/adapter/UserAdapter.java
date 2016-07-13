package com.software.moisesc.proyfinalandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.software.moisesc.proyfinalandroid.R;
import com.software.moisesc.proyfinalandroid.model.User;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Moises on 10/07/2016.
 */
public class UserAdapter extends ArrayAdapter<User> {
    public UserAdapter(Context context) {
        super(context, R.layout.user_item_layout);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        User user = getItem(position);
        View currentView;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            currentView = inflater.inflate(R.layout.user_item_layout, parent, false);
        } else {
            currentView = convertView;
        }

        TextView usernameTextView = (TextView)currentView.findViewById(R.id.usename_text_view);
        TextView emailTextView = (TextView)currentView.findViewById(R.id.email_text_view);
        CircleImageView profileImageView = (CircleImageView) currentView.findViewById(R.id.user_image_view);

        usernameTextView.setText(user.getUsername());
        emailTextView.setText(user.getEmail());
        Glide.with(getContext()).load(user.getPicture_url()).into(profileImageView);

        return currentView;
    }
}
