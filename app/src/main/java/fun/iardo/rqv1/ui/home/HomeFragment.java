package fun.iardo.rqv1.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import fun.iardo.rqv1.R;
import fun.iardo.rqv1.common.PresenterFragment;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class HomeFragment extends PresenterFragment implements HomeView{
    private View mErrorView;
    private TextView tv_home;

    @InjectPresenter
    HomePresenter mPresenter;
    @ProvidePresenter
    HomePresenter providePresenter(){
        return new HomePresenter();
    }

    public HomeFragment(){}


    public static HomeFragment newInstance(){return new HomeFragment();}

    @Override
    protected HomePresenter getPresenter() {
        return mPresenter;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void showData() {
    }

    @Override
    public void showError() {

    }
}