package com.sauyee333.networksample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sauyee333.networksample.R;
import com.sauyee333.networksample.adapter.RowAdapter;
import com.sauyee333.networksample.model.RowInfo;
import com.sauyee333.networksample.model.response.Entries;
import com.sauyee333.networksample.model.response.Feed;
import com.sauyee333.networksample.model.response.ResponseData;
import com.sauyee333.networksample.model.response.ServiceFeed;
import com.sauyee333.networksample.network.retrofitMethod.NetworkCallback;
import com.sauyee333.networksample.network.retrofitMethod.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sauyee on 19/9/16.
 */
public class RetrofitFragment extends Fragment {
    @Bind(R.id.list)
    RecyclerView mRecyclerListView;

    private RowAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
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
        RetrofitClient.getInstance().getServiceApi(new NetworkCallback<ServiceFeed>() {
            @Override
            protected void onSuccess(ServiceFeed serviceFeed) {
                if (serviceFeed != null) {
                    displayTitle(serviceFeed.getResponseData());
                }
            }

            @Override
            protected void onFailure(boolean isNetworkFailure, String responseDetails, String responseStatus) {

            }
        }, getResources().getString(R.string.urlQuery));
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
