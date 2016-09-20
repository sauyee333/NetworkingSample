package com.sauyee333.networksample.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.sauyee333.networksample.R;
import com.sauyee333.networksample.adapter.RowAdapter;
import com.sauyee333.networksample.model.RowInfo;
import com.sauyee333.networksample.model.response.Entries;
import com.sauyee333.networksample.model.response.Feed;
import com.sauyee333.networksample.model.response.ResponseData;
import com.sauyee333.networksample.model.response.ServiceFeed;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sauyee on 19/9/16.
 */
public class VolleyFragment extends Fragment {
    @Bind(R.id.list)
    RecyclerView mRecyclerListView;

    private RowAdapter mAdapter;
    private Context mContext;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        mContext = getContext();
        setupListConfig();
        getServiceFeed();
        return view;
    }

    private void setupListConfig() {
        mRecyclerListView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerListView.setLayoutManager(layoutManager);
    }

    private void getServiceFeed() {
        String url = getResources().getString(R.string.urlPath) + getResources().getString(R.string.urlQuery);
        StringRequest stringRequest = new StringRequest(url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                ServiceFeed serviceFeed = new Gson().fromJson(response, ServiceFeed.class);
                if (serviceFeed != null) {
                    displayTitle(serviceFeed.getResponseData());
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(mContext, error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
        RequestQueue requestQueue = Volley.newRequestQueue(mContext);
        requestQueue.add(stringRequest);
    }

    private void displayTitle(ResponseData responseData) {
        if (responseData != null) {
            Feed feed = responseData.getFeed();
            if (feed != null) {
                Entries[] entries = feed.getEntries();
                if (entries.length > 0) {
                    List<RowInfo> itemList = new ArrayList<>();
                    for (int i = 0; i < entries.length; i++) {
                        itemList.add(new RowInfo(entries[i].getTitle()));
                    }
                    mAdapter = new RowAdapter(itemList, null);
                    mRecyclerListView.setAdapter(mAdapter);
                }
            }
        }
    }
}
