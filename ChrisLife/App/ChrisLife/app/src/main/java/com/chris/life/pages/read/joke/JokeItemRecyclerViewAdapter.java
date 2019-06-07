package com.chris.life.pages.read.joke;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chris.life.R;
import com.chris.life.pages.read.joke.JokeFragment.OnListFragmentInteractionListener;
import com.chris.life.pages.read.joke.dummy.JokeContent.JokeItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link JokeItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class JokeItemRecyclerViewAdapter extends RecyclerView.Adapter<JokeItemRecyclerViewAdapter.ViewHolder> {

    private final List<JokeItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public JokeItemRecyclerViewAdapter(List<JokeItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_news_joke, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.jokeContent.setText(mValues.get(position).content);
        holder.jokeUpdateTime.setText(mValues.get(position).updatetime);

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
        public final TextView jokeUpdateTime;
        public final TextView jokeContent;
        public JokeItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            jokeContent = view.findViewById(R.id.joke_item_content);
            jokeUpdateTime = view.findViewById(R.id.joke_item_time);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + jokeContent.getText() + "'";
        }
    }
}
