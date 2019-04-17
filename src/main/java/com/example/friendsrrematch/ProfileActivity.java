package com.example.friendsrrematch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class ProfileActivity extends AppCompatActivity {

    String name;
    RatingBar bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

//        get information from main function
        Intent intent = getIntent();
        Friend retrievedFriend = (Friend) intent.getSerializableExtra("clicked_friend");

//        get the required items to set in grid_items
        name = retrievedFriend.getName();
        String bio = retrievedFriend.getBio();
        int drawable_id = retrievedFriend.getDrawableId();
        float rating = retrievedFriend.getRating();

//        find views in grid_item layout
        ImageView picture = findViewById(R.id.picture);
        TextView Name = findViewById(R.id.name);
        TextView Bio = findViewById(R.id.bio);
        bar = findViewById(R.id.ratingBar);

//        Set views in grid_items layout
        bar.setRating(load());
        Name.setText(name);
        Bio.setText(bio);
        picture.setImageResource(drawable_id);


//        if rating is changed, change rating variable
        bar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                save(rating);
            }
        });

    }
    public void save(float f){

//        save SharedPreference correct with editor
        SharedPreferences sharedPreferences=getSharedPreferences("{}".format(name),MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat("rating",f);
        editor.commit();
    }
    public float load(){
//        load the SharedPreference if already saved
        SharedPreferences sharedPreferences=getSharedPreferences("{}".format(name),MODE_PRIVATE);
        float f=sharedPreferences.getFloat("rating",0);
        return f;
    }
}
