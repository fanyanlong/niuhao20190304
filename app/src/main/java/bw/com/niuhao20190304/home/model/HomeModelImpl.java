package bw.com.niuhao20190304.home.model;

import bw.com.niuhao20190304.api.Api;
import bw.com.niuhao20190304.api.ApiServer;
import bw.com.niuhao20190304.bean.ShowBean;
import bw.com.niuhao20190304.utils.RetrofitManager;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HomeModelImpl implements IHomeModel {
    @Override
    public void home(String url, final IHomeFace homeFace) {
        ApiServer apiServer = RetrofitManager.getInstance(Api.BASE_URL).setCreate(ApiServer.class);
        apiServer.show(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new DisposableObserver<ShowBean>() {
                    @Override
                    public void onNext(ShowBean value) {
                        homeFace.onSuccess(value);
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
