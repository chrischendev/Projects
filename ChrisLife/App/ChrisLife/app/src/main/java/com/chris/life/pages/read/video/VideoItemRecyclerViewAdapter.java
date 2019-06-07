package com.chris.life.pages.read.video;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chris.life.R;
import com.chris.life.pages.read.video.VideoFragment.OnListFragmentInteractionListener;
import com.chris.life.pages.read.video.dummy.VideoContent.VideoItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link VideoItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class VideoItemRecyclerViewAdapter extends RecyclerView.Adapter<VideoItemRecyclerViewAdapter.ViewHolder> {

    private final List<VideoItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public VideoItemRecyclerViewAdapter(List<VideoItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news_video, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.videoTitle.setText(mValues.get(position).title);
        holder.videoContent.setText(mValues.get(position).content);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView videoTitle;
        public final TextView videoContent;
        public VideoItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            videoTitle = view.findViewById(R.id.video_item_title);
            videoContent = view.findViewById(R.id.video_item_content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + videoContent.getText() + "'";
        }
    }
}
