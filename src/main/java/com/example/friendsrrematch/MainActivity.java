package com.example.friendsrrematch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Friend> friends = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addition();
        GridView grid_view = findViewById(R.id.grid_view);
        grid_view.setAdapter(new FriendsAdapter(this, 0, friends));
        grid_view.setOnItemClickListener(new GridItemClickListener());
    }

    public void addition(){

        Friend Iris = new Friend("Iris","Lekkerding hoor", getResources().getIdentifier("pic1", "drawable", getPackageName()));
        Friend Simon = new Friend("Simon","manssss", getResources().getIdentifier("pic2", "drawable", getPackageName()));
        Friend Christiaan = new Friend("Christiaan","bar zitten dom kijken", getResources().getIdentifier("pic3", "drawable", getPackageName()));
        Friend Dylan = new Friend("Dylan","vroege vader", getResources().getIdentifier("pic4", "drawable", getPackageName()));
        Friend Fons = new Friend("Fons","Dat zal amy niet leuk vinden", getResources().getIdentifier("pic5", "drawable", getPackageName()));
        Friend Cesar = new Friend("Cesar","ouwe pilsbaas", getResources().getIdentifier("pic6", "drawable", getPackageName()));
        Friend Tim = new Friend("Tim","Lastig hé, github.", getResources().getIdentifier("pic7", "drawable", getPackageName()));
        friends.add(Iris);
        friends.add(Simon);
        friends.add(Christiaan);
        friends.add(Dylan);
        friends.add(Fons);
        friends.add(Cesar);
        friends.add(Tim);
    }

    private class GridItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Friend clickedFriend = friends.get(position);

            Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
            intent.putExtra("clicked_friend", clickedFriend);
            startActivity(intent);
        }
    }
}