package bw.com.niuhao20190304.banner.model;

public interface IBannerModel {
    public void banner(String url,IBannerFace bannerFace);
    public interface IBannerFace{
        void onSuccess(Object obj);
        void onError(Throwable e);
    }
}
