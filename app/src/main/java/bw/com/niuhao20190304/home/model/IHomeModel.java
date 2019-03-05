package bw.com.niuhao20190304.home.model;

public interface IHomeModel {
    public void home(String url,IHomeFace homeFace);
    public interface IHomeFace{
        void onSuccess(Object object);
        void onError(Throwable e);
    }
}
