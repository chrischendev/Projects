package com.chris.life.pages.read.joke;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chris.life.R;
import com.chris.life.api.common.JuheResponse;
import com.chris.life.api.joke.JokeApi;
import com.chris.life.pages.read.joke.dummy.JokeContent;
import com.chris.life.pages.read.joke.dummy.JokeContent.JokeItem;

import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class JokeFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;
    private JokeItemRecyclerViewAdapter adapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public JokeFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static JokeFragment newInstance(int columnCount) {
        JokeFragment fragment = new JokeFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fra_joke_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            adapter = new JokeItemRecyclerViewAdapter(JokeContent.ITEMS, mListener);
            recyclerView.setAdapter(adapter);

            //long time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2019-05-23 00:00:00").getTime() / 1000;
            //long time = 1418816972L;
            long time = new Date().getTime() / 1000;
            JokeApi.getJokeList(1, 20, "desc", time, new Callback<JuheResponse<JokeItem>>() {
                @Override
                public void onResponse(Call<JuheResponse<JokeItem>> call, Response<JuheResponse<JokeItem>> response) {
                    System.out.println(response.body().getResult().getData().size());
                    JokeContent.ITEMS.clear();
                    JokeContent.ITEMS.addAll(response.body().getResult().getData());
                    adapter.notifyDataSetChanged();
                }

                @Override
                public void onFailure(Call<JuheResponse<JokeItem>> call, Throwable t) {

                }
            });
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(JokeItem item);
    }
}
