package com.example.a91256.freedomandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.baoyz.widget.PullRefreshLayout;
import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.adapter.RankListAdapter;
import com.example.a91256.freedomandroid.base.BaseView;
import com.example.a91256.freedomandroid.bean.ComicListBean;
import com.example.a91256.freedomandroid.bean.RankDetailBean;
import com.example.a91256.freedomandroid.bean.RankinglistBean;
import com.example.a91256.freedomandroid.presenter.RankDetailPresenter;

import java.util.ArrayList;

/**
 * Created by 91256 on 2017/4/6.
 */

public class ComicRankDetailFragment extends Fragment implements BaseView{
    public static final String TYPE_UP = "up";
    public static final String TYPE_DOWN = "down";
    private final String TAG = "ComicRankDetailFragment";

    private int currentPage = 1;
    private boolean isloading = false;
    private String argName;
    private String argValue;
    private String loadType;
    private boolean loadMore = true;


    private RankinglistBean mRankBean;
    private RankDetailPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private PullRefreshLayout pullRefreshLayout;
    private RankListAdapter adapter;
    private ArrayList<RankDetailBean> listBean = new ArrayList<>();
    private View nothingMore ;


    public static Fragment getInstance(RankinglistBean bean){
        Fragment fragment = new ComicRankDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("data",bean);
        fragment.setArguments(bundle);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        this.mRankBean = (RankinglistBean)getArguments().get("data");
        this.argName = mRankBean.getArgName();
        this.argValue = mRankBean.getArgValue();
        mPresenter = new RankDetailPresenter(this);
        adapter = new RankListAdapter(getActivity());
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.comic_rank_detail,null,false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.list);
        pullRefreshLayout = (PullRefreshLayout)view.findViewById(R.id.pullrefresh_layout);
        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                loadType = TYPE_DOWN;
                mPresenter.loadData(1,argName,argValue);
            }
        });
        nothingMore = inflater.inflate(R.layout.ranklist_nothing_more,null,false);
        nothingMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.removeFooter(nothingMore);
                currentPage++;
                loadType = TYPE_UP;
                mPresenter.loadData(currentPage,argName,argValue);
            }
        });
        initList();
        loadType = TYPE_DOWN;
        mPresenter.loadData(1,argName,argValue);
        return view;
    }

    private void initList(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        if(listBean != null && listBean.size() > 0){
            adapter.setData(listBean);
        }
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int totalCount = recyclerView.getAdapter().getItemCount();
                int visibleCount = recyclerView.getChildCount();
                int firstPosition = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

                if(!isloading && totalCount - firstPosition - visibleCount <= 2 && loadMore){
                    currentPage++;
                    loadType = TYPE_UP;
                    mPresenter.loadData(currentPage,argName,argValue);
                    isloading = true;
                }
            }
        });
    }

    @Override
    public void loadComplete(Object object) {
        Log.e(TAG,"loadcomplete");
        if(object instanceof ComicListBean){
            ComicListBean bean = (ComicListBean) object;
            if(bean.getData()!=null && bean.getData().getReturnData()!=null) {
                if (TYPE_DOWN.equals(loadType)) {
                    listBean = bean.getData().getReturnData().getComics();
                    adapter.setData(listBean);
                    adapter.notifyDataSetChanged();
                    pullRefreshLayout.setRefreshing(false);
                } else if (TYPE_UP.equals(loadType)) {
                    listBean.addAll(bean.getData().getReturnData().getComics());
                    adapter.setData(listBean);
                    adapter.notifyDataSetChanged();
                    isloading = false;
                }
                adapter.removeFooter(nothingMore);
                loadMore = true;
            }else{
                if(TYPE_DOWN.equals(loadType)){
                    Toast.makeText(getActivity(),"没有新数据",Toast.LENGTH_SHORT).show();
                }else if(TYPE_UP.equals(loadType)){
                    adapter.addFooterView(nothingMore);
                    loadMore = false;
                    isloading = false;
                }
            }
        }
    }

    @Override
    public void loadFail() {
        Log.e(TAG,"loadfail");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

}
