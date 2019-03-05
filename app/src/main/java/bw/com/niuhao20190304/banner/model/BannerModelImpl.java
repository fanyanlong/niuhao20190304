package bw.com.niuhao20190304.banner.model;

import bw.com.niuhao20190304.api.Api;
import bw.com.niuhao20190304.api.ApiServer;
import bw.com.niuhao20190304.bean.BannerBean;
import bw.com.niuhao20190304.utils.RetrofitManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class BannerModelImpl implements IBannerModel {
    @Override
    public void banner(String url, final IBannerFace bannerFace) {
        ApiServer apiServer = RetrofitManager.getInstance(Api.BASE_URL).setCreate(ApiServer.class);
        apiServer.banner(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<BannerBean>() {
                    @Override
                    public void onNext(BannerBean value) {
                        bannerFace.onSuccess(value);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
