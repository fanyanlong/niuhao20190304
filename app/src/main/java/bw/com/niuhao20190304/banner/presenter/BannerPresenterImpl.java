package bw.com.niuhao20190304.banner.presenter;

import bw.com.niuhao20190304.api.Api;
import bw.com.niuhao20190304.banner.model.BannerModelImpl;
import bw.com.niuhao20190304.banner.model.IBannerModel;
import bw.com.niuhao20190304.fragment.FaFragment;

public class BannerPresenterImpl implements IBannerPresenter {
    FaFragment fa;
    private final BannerModelImpl bannerModel;

    public BannerPresenterImpl(FaFragment faFragment) {
        this.fa = faFragment;
        bannerModel = new BannerModelImpl();
    }

    @Override
    public void bannerPresenter() {
        bannerModel.banner(Api.BANNER_URL, new IBannerModel.IBannerFace() {
            @Override
            public void onSuccess(Object obj) {
                fa.bannerView(obj);
            }

            @Override
            public void onError(Throwable e) {

            }
        });
    }

    public void destory(){
        if (fa!=null){
            fa = null;
        }
    }
}
