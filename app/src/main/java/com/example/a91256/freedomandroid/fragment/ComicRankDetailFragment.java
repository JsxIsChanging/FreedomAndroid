package com.example.a91256.freedomandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baoyz.widget.PullRefreshLayout;
import com.example.a91256.freedomandroid.R;
import com.example.a91256.freedomandroid.base.BaseView;
import com.example.a91256.freedomandroid.bean.ComicListBean;
import com.example.a91256.freedomandroid.bean.RankDetailBean;
import com.example.a91256.freedomandroid.bean.RankinglistBean;
import com.example.a91256.freedomandroid.presenter.RankDetailPresenter;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;

/**
 * Created by 91256 on 2017/4/6.
 */

public class ComicRankDetailFragment extends Fragment implements BaseView{
    private RankinglistBean mRankBean;
    private RankDetailPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private PullRefreshLayout pullRefreshLayout;
    private MyAdapter adapter;
    private ArrayList<RankDetailBean> listBean = new ArrayList<>();


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
        mPresenter = new RankDetailPresenter(this);
        adapter = new MyAdapter();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate( R.layout.comic_rank_detail,container,false);
        mRecyclerView = (RecyclerView)view.findViewById(R.id.list);
        pullRefreshLayout = (PullRefreshLayout)view.findViewById(R.id.pullrefresh_layout);
        pullRefreshLayout.setOnRefreshListener(new PullRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mPresenter.loadData(1,mRankBean.getArgName(),mRankBean.getArgValue());
            }
        });
        initList();
        mPresenter.loadData(1,mRankBean.getArgName(),mRankBean.getArgValue());
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
    }

    @Override
    public void loadComplete(Object object) {
        if(object instanceof ComicListBean){
            ComicListBean bean = (ComicListBean)object;
            listBean = bean.getData().getReturnData().getComics();
            adapter.setData(listBean);
            adapter.notifyDataSetChanged();
            pullRefreshLayout.setRefreshing(false);
        }
    }

    @Override
    public void loadFail() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void stopLoading() {

    }

    public class MyAdapter extends RecyclerView.Adapter<MyViewHolder>{
        private ArrayList<RankDetailBean> items = new ArrayList<>();

        public void setData(ArrayList<RankDetailBean> list){
            this.items = list;
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new MyViewHolder(View.inflate(getContext(),R.layout.rank_detail_item,null));
        }

        @Override
        public void onBindViewHolder(MyViewHolder myViewHolder, int i) {
            myViewHolder.img.setImageURI(items.get(i).getCover());
            myViewHolder.title.setText(items.get(i).getName());
            ArrayList<String> tags = items.get(i).getTags();
            String str = "";
            for(int m = 0; m< tags.size()-1; m++){
                str  = str + tags.get(m) + " | ";
            }
            str +=  tags.get(tags.size()-1);
            myViewHolder.type.setText(str);
            myViewHolder.des.setText("  " + items.get(i).getDescription());
        }

        @Override
        public int getItemCount() {
            return items.size();
        }
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        public SimpleDraweeView img;
        public TextView title;
        public TextView type;
        public TextView des;
        public MyViewHolder(View itemView) {
            super(itemView);
            img = (SimpleDraweeView)itemView.findViewById(R.id.detail_img);
            type = (TextView)itemView.findViewById(R.id.detail_type);
            des = (TextView)itemView.findViewById(R.id.detail_des);
            title = (TextView)itemView.findViewById(R.id.detail_title);
        }
    }
}
