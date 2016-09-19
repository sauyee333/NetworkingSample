package com.sauyee333.networksample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sauyee333.networksample.R;
import com.sauyee333.networksample.adapter.RowAdapter;
import com.sauyee333.networksample.listener.RowSelectListener;
import com.sauyee333.networksample.model.RowInfo;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by sauyee on 19/9/16.
 */
public class VolleyFragment extends Fragment implements RowSelectListener{
    private static final int MAIN_ROW_VOLLEY = 0;
    private static final int MAIN_ROW_RETROFIT2 = 1;

    @Bind(R.id.list)
    RecyclerView mRecyclerListView;

    private RowAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        setupListConfig();
        showList();
        _Debug("oncr");
        return view;
    }

    private void setupListConfig() {
        mRecyclerListView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerListView.setLayoutManager(layoutManager);
    }

    private void showList() {
        List<RowInfo> itemList = getMeList();

        mAdapter = new RowAdapter(itemList, VolleyFragment.this);
        mRecyclerListView.setAdapter(mAdapter);
    }

    private List<RowInfo> getMeList() {
        List<RowInfo> itemList = new ArrayList<>();
        itemList.add(new RowInfo(getResources().getString(R.string.volley)));
        itemList.add(new RowInfo(getResources().getString(R.string.retrofit)));

        return itemList;
    }

    @Override
    public void onRowClick(int position) {
        _Debug("onrow click: " + position);
        switch (position){
            case MAIN_ROW_VOLLEY:
_Debug("volley");
                break;
            case MAIN_ROW_RETROFIT2:
                _Debug("retrofits");
                break;
        }
    }

    private static void _Debug(String str) {
        Log.d("widget", str);
    }
}
