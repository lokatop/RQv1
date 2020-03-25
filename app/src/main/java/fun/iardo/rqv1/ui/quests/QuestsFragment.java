package fun.iardo.rqv1.ui.quests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import fun.iardo.rqv1.R;
import fun.iardo.rqv1.common.PresenterFragment;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class QuestsFragment extends PresenterFragment implements QuestsView {
    private View mErrorView;
    private TextView tv_quests;

    @InjectPresenter
    QuestsPresenter mPresenter;
    @ProvidePresenter
    QuestsPresenter providePresenter(){
        return new QuestsPresenter();
    }

    public QuestsFragment(){}


    public static QuestsFragment newInstance(){return new QuestsFragment();}

    @Override
    protected QuestsPresenter getPresenter() {
        return mPresenter;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_quests,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tv_quests = view.findViewById(R.id.text_quests);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv_quests.setText("Квестс фрагмент");
    }

}