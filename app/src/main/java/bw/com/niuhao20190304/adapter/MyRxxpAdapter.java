package bw.com.niuhao20190304.adapter;
import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.facebook.drawee.view.SimpleDraweeView;
import butterknife.BindView;
import butterknife.ButterKnife;
import bw.com.niuhao20190304.R;
import bw.com.niuhao20190304.bean.ShowBean;

public class MyRxxpAdapter extends RecyclerView.Adapter<MyRxxpAdapter.ViewHolder> {
    Context context;
    ShowBean showBean;
    private ShowBean.ResultBean.PzshBean pzshBean;
    private ShowBean.ResultBean.RxxpBean rxxpBean;
    private ShowBean.ResultBean.MlssBean mlssBean;
    public MyRxxpAdapter(Context context, ShowBean showBean) {
        this.context = context;
        this.showBean = showBean;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.rxxp_layout, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        showBean.getType();
        if( showBean.getType().equals("0")){
            rxxpBean = showBean.getResult().getRxxp();
            Uri uri = Uri.parse(rxxpBean.getCommodityList().get(i).getMasterPic());
            viewHolder.simPleRxxp.setImageURI(uri);
            viewHolder.textNameRxxp.setText(rxxpBean.getCommodityList().get(i).getCommodityName());
            viewHolder.textPriceRxxp.setText("￥"+rxxpBean.getCommodityList().get(i).getPrice());
        }else if (showBean.getType().equals("1")){
            pzshBean = showBean.getResult().getPzsh();
            Uri uri = Uri.parse(pzshBean.getCommodityList().get(i).getMasterPic());
            viewHolder.simPleRxxp.setImageURI(uri);
            viewHolder.textNameRxxp.setText(pzshBean.getCommodityList().get(i).getCommodityName());
            viewHolder.textPriceRxxp.setText("￥"+pzshBean.getCommodityList().get(i).getPrice());

        }else if (showBean.getType().equals("2")){
            mlssBean = showBean.getResult().getMlss();
            Uri uri = Uri.parse(mlssBean.getCommodityList().get(i).getMasterPic());
            viewHolder.simPleRxxp.setImageURI(uri);
            viewHolder.textNameRxxp.setText(mlssBean.getCommodityList().get(i).getCommodityName());
            viewHolder.textPriceRxxp.setText("￥"+mlssBean.getCommodityList().get(i).getPrice());

        }


    }

    @Override
    public int getItemCount() {
        if( showBean.getType().equals("0")){
            return showBean.getResult().getRxxp().getCommodityList().size();
        }else if (showBean.getType().equals("1")){
            return showBean.getResult().getPzsh().getCommodityList().size();
        }else if (showBean.getType().equals("2")){
           return showBean.getResult().getMlss().getCommodityList().size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.text_name_rxxp)
        TextView textNameRxxp;
        @BindView(R.id.text_price_rxxp)
        TextView textPriceRxxp;
        @BindView(R.id.simPle_rxxp)
        SimpleDraweeView simPleRxxp;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
