package bw.com.niuhao20190304.fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.stx.xhb.xbanner.XBanner;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import bw.com.niuhao20190304.BannerActivity;
import bw.com.niuhao20190304.R;
import bw.com.niuhao20190304.adapter.MyRxxpAdapter;
import bw.com.niuhao20190304.bean.ShowBean;
import bw.com.niuhao20190304.banner.presenter.BannerPresenterImpl;
import bw.com.niuhao20190304.banner.view.IBannerView;
import bw.com.niuhao20190304.bean.BannerBean;
import bw.com.niuhao20190304.home.presenter.HomePresenterImpl;
import bw.com.niuhao20190304.home.view.IHomeView;

public class FaFragment extends Fragment implements IBannerView, IHomeView {

    @BindView(R.id.banner)
    XBanner banner;
    Unbinder unbinder;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.btn_huan)
    TextView btnHuan;
    @BindView(R.id.text_name)
    TextView textName;
    private BannerPresenterImpl bannerPresenter;
    private HomePresenterImpl homePresenter;
    private int count = 1;
    private ShowBean showBean;
    public static final String TAG="FaFragment";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView: ");
        View view = inflater.inflate(R.layout.fragment_fa, container, false);
        bannerPresenter = new BannerPresenterImpl(FaFragment.this);
        bannerPresenter.bannerPresenter();
        homePresenter = new HomePresenterImpl(FaFragment.this);
        homePresenter.homePresenter();
        unbinder = ButterKnife.bind(this, view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(OrientationHelper.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        btnHuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if (showBean.getType().equals("0")) {
                        showBean.setType("1");
                        textName.setText(showBean.getResult().getRxxp().getName());}
                    else if (showBean.getType().equals("1")) {
                        showBean.setType("2");
                        textName.setText(showBean.getResult().getPzsh().getName());
                    }
                    else if (showBean.getType().equals("2")) {
                        showBean.setType("0");
                        textName.setText(showBean.getResult().getMlss().getName());
                    }
                MyRxxpAdapter myRxxpAdapter = new MyRxxpAdapter(getActivity(), showBean);
                recyclerView.setAdapter(myRxxpAdapter);
            }
        });
        return view;
    }
    //懒加载
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.i(TAG, "setUserVisibleHint: ");
    }

    @Override
    public void bannerView(Object obj) {
        if (obj != null) {
            final BannerBean bannerBean = (BannerBean) obj;
//            Log.i("aa", "bannerBean:" + bannerBean.getMessage());
            banner.setData(bannerBean.getResult(), null);
            banner.loadImage(new XBanner.XBannerAdapter() {
                @Override
                public void loadBanner(XBanner banner, Object model, View view, int position) {
                    BannerBean.ResultBean bean = (BannerBean.ResultBean) model;
                    Glide.with(getActivity()).load(bean.getImageUrl()).into((ImageView) view);
                    banner.setPageChangeDuration(1000);
                }
            });
            banner.setOnItemClickListener(new XBanner.OnItemClickListener() {
                @Override
                public void onItemClick(XBanner banner, Object model, View view, int position) {
                    Intent intent = new Intent(getActivity(),BannerActivity.class);
                    intent.putExtra("image",bannerBean.getResult().get(position).getJumpUrl());
                    startActivity(intent);
                }
            });
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        Log.i(TAG, "onDestroyView: ");
    }

    @Override
    public void homeView(Object obj) {
        if (obj != null) {
            showBean = (ShowBean) obj;
            if (showBean != null) {
                textName.setText(showBean.getResult().getRxxp().getName());
                MyRxxpAdapter myRxxpAdapter = new MyRxxpAdapter(getActivity(), showBean);
                recyclerView.setAdapter(myRxxpAdapter);
            }
        }
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        Log.i(TAG, "onHiddenChanged: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        bannerPresenter.destory();
        homePresenter.destory();
        Log.i(TAG, "onDestroy: ");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: ");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: ");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: ");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: ");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: ");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG, "onDetach: ");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, "onAttach: ");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG, "onActivityCreated: ");
    }
}
