package com.appbuilder.truemusic.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.appbuilder.truemusic.R;
import com.appbuilder.truemusic.model.Chat;

import java.util.List;

/**
 * Created by toon on 11/25/2017.
 */

public class ChatAdapter extends BaseAdapter {

    private Context mContext;
    private List<Chat> mList;

    public ChatAdapter(Context context, List<Chat> tracks) {
        mContext = context;
        mList = tracks;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Chat getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Chat item = getItem(position);

        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.chat_list_row, parent, false);
            holder = new ViewHolder();
            holder.name = convertView.findViewById(R.id.chat_name_text_view);
            holder.time = convertView.findViewById(R.id.chat_time_text_view);
            holder.message = convertView.findViewById(R.id.chat_text_text_view);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(item.getName());
        holder.time.setText(item.getTime());
        holder.message.setText(item.getMessage());

        return convertView;
    }

    static class ViewHolder {
        TextView name;
        TextView time;
        TextView message;
    }

}