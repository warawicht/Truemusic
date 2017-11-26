package com.appbuilder.truemusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.appbuilder.truemusic.R;
import com.appbuilder.truemusic.model.Chat;
import com.appbuilder.truemusic.model.StringDataObject;

import java.util.List;

/**
 * Created by toon on 11/25/2017.
 */

public class SearchAdapter extends BaseAdapter {

    private Context mContext;
    private List<StringDataObject> mList;

    public SearchAdapter(Context context, List<StringDataObject> tracks) {
        mContext = context;
        mList = tracks;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public StringDataObject getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        StringDataObject item = getItem(position);

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.search_list_row, parent, false);
            holder = new ViewHolder();
            holder.image = convertView.findViewById(R.id.searched_item_image);
            holder.text = convertView.findViewById(R.id.searched_item_text);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.image.setImageResource(mContext.getResources().getIdentifier(item.getText2(), "drawable", mContext.getPackageName()));
        holder.text.setText(item.getText1());
        return convertView;
    }

    static class ViewHolder {
        ImageView image;
        TextView text;
    }

}