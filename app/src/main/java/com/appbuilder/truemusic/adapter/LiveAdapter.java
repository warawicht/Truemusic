package com.appbuilder.truemusic.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appbuilder.truemusic.R;
import com.appbuilder.truemusic.model.Live;

import java.util.List;

/**
 * Created by toon on 11/26/2017.
 */

public class LiveAdapter extends RecyclerView.Adapter<LiveAdapter.CustomerViewHolder> {

    private Context mContext;
    private List<Live> mList;
    private CustomOnItemClickListener<Live> customOnItemClickListener;

    public LiveAdapter(Context context, List<Live> list) {
        mContext = context;
        mList = list;
    }

    @Override
    public CustomerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.live_card_view, null);
        CustomerViewHolder viewHolder = new CustomerViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(CustomerViewHolder holder, int position) {
        final Live item = mList.get(position);
        holder.name.setText(item.getName());
        holder.tag.setText(item.getTag());
        holder.image.setImageResource(mContext.getResources().getIdentifier(item.getImage(), "drawable", mContext.getPackageName()));

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customOnItemClickListener.onItemClick(item);
            }
        };
        holder.name.setOnClickListener(listener);
        holder.tag.setOnClickListener(listener);
        holder.image.setOnClickListener(listener);

    }

    public void setCustomOnItemClickListener(CustomOnItemClickListener<Live> customOnItemClickListener) {
        this.customOnItemClickListener = customOnItemClickListener;
    }

    @Override
    public int getItemCount() {
        return (null != mList ? mList.size() : 0);
    }

    static class CustomerViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView name;
        TextView tag;

        public CustomerViewHolder(View itemView) {
            super(itemView);
            this.image = itemView.findViewById(R.id.live_image);
            this.name = itemView.findViewById(R.id.live_name);
            this.tag = itemView.findViewById(R.id.live_tag);
        }
    }
}
