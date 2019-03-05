package bw.com.niuhao20190304.api;

import bw.com.niuhao20190304.bean.ShowBean;
import bw.com.niuhao20190304.bean.BannerBean;
import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface ApiServer {

    //Banner
    @GET
    Observable<BannerBean> banner(@Url String url);
    //首页
    @GET
    Observable<ShowBean> show(@Url String url);
}
