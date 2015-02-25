package com.example.celder.instagramclient;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.text.format.DateUtils;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by celder on 2/23/15.
 */
public class InstagramPhotosAdapter extends ArrayAdapter<InstagramPhoto> {
    public InstagramPhotosAdapter(Context context, List<InstagramPhoto> objects) {
        super(context, android.R.layout.simple_list_item_1, objects);
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        InstagramPhoto photo = getItem(pos);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_photo, parent, false);
        }
        // add username
        TextView userName = (TextView) convertView.findViewById(R.id.userName);
        userName.setText(photo.username);
        Log.i("DEBUG", "setting userName text to: " + photo.username);

        // add user photo
        ImageView userPhoto = (ImageView) convertView.findViewById(R.id.userView);
        userPhoto.setImageResource(0);
        Log.i("DEBUG", "loading into userPhoto, image url: " + photo.userImageUrl);
        Picasso.with(getContext()).load(photo.userImageUrl).into(userPhoto);

        // add timestamp
        TextView timeCaption = (TextView) convertView.findViewById(R.id.timeCaption);
        timeCaption.setText(DateUtils.getRelativeTimeSpanString(photo.timestamp));

        // add photo caption
        TextView tvCaption = (TextView) convertView.findViewById(R.id.tvCaption);
        String captionText = photo.caption;
        Log.i("DEBUG", "setting tvCaption text to: " + captionText);
        tvCaption.setText(captionText);

        // clear out image view and set photo
        ImageView ivPhoto = (ImageView) convertView.findViewById(R.id.ivPhoto);
        ivPhoto.setImageResource(0);
        // insert image using picasso
        Log.i("DEBUG", "loading into ivPhoto, image url: " + photo.imageUrl);
        Picasso.with(getContext()).load(photo.imageUrl).into(ivPhoto);

        return convertView;
    }
}
