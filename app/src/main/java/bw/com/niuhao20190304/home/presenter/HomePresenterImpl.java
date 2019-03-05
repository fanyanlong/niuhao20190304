package bw.com.niuhao20190304.home.presenter;

import bw.com.niuhao20190304.api.Api;
import bw.com.niuhao20190304.fragment.FaFragment;
import bw.com.niuhao20190304.home.model.HomeModelImpl;
import bw.com.niuhao20190304.home.model.IHomeModel;

public class HomePresenterImpl implements IHomePresenter {
    FaFragment fa;
    private final HomeModelImpl homeModel;

    public HomePresenterImpl(FaFragment faFragment) {
        this.fa = faFragment;
        homeModel = new HomeModelImpl();
    }

    @Override
    public void homePresenter() {
        homeModel.home(Api.SHOW_URL, new IHomeModel.IHomeFace() {
            @Override
            public void onSuccess(Object object) {
                fa.homeView(object);
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
