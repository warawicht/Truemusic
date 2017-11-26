package com.appbuilder.truemusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appbuilder.truemusic.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by toon on 11/25/2017.
 */

public class BrowseMenuAdapter extends BaseAdapter {

    private Context mContext;
    private List<String> mList;

    public BrowseMenuAdapter(Context context, List<String> tracks) {
        mContext = context;
        mList = tracks;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public String getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String item = getItem(position);

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.browse_menu_list_row, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.browse_menu_image);
            holder.textView = convertView.findViewById(R.id.browse_menu_title);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText(item);
        holder.imageView.setImageResource(R.drawable.ic_chevron_right_48pt);

        return convertView;
    }

    static class ViewHolder {
        ImageView imageView;
        TextView textView;
    }
}