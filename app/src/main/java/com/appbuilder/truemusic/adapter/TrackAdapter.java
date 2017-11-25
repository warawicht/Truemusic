package com.appbuilder.truemusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appbuilder.truemusic.R;
import com.appbuilder.truemusic.model.Track;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by toon on 11/25/2017.
 */

public class TrackAdapter extends BaseAdapter {

    private Context mContext;
    private List<Track> mList;

    public TrackAdapter(Context context, List<Track> tracks) {
        mContext = context;
        mList = tracks;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Track getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Track item = getItem(position);

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.track_list_row, parent, false);
            holder = new ViewHolder();
            holder.trackImageView = convertView.findViewById(R.id.track_image);
            holder.titleTextView = convertView.findViewById(R.id.track_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.titleTextView.setText(item.getName());

        // Trigger the download of the URL asynchronously into the image view.
        Picasso.with(mContext).load(item.getAlbumPicture()).into(holder.trackImageView);

        return convertView;
    }

    static class ViewHolder {
        ImageView trackImageView;
        TextView titleTextView;
    }

}