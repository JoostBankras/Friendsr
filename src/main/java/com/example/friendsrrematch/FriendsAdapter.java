package com.example.friendsrrematch;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class FriendsAdapter extends ArrayAdapter<Friend> {
    private ArrayList<Friend> friends;

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        if there is no view, make a view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.grid_item, parent, false);
        }

//        get the text and pic view
        TextView name = convertView.findViewById(R.id.Name);
        ImageView pic = convertView.findViewById(R.id.picture);

//        set the text and pic view to preferenced text and picture
        name.setText(friends.get(position).getName());
        pic.setImageResource(friends.get(position).getDrawableId());

        return convertView;
    }

    public FriendsAdapter(Context context, int resource, ArrayList<Friend> objects) {
//        get all the friends through the loop
        super(context, resource, objects);
        friends = objects;
    }
}
