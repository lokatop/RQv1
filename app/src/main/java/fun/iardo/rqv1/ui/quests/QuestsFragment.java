package fun.iardo.rqv1.ui.quests;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fun.iardo.rqv1.R;
import fun.iardo.rqv1.common.PresenterFragment;
import fun.iardo.rqv1.common.Refreshable;
import fun.iardo.rqv1.data.model.QuestModel;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class QuestsFragment extends PresenterFragment implements
        QuestsView,QuestAdapter.OnItemClickListener, Refreshable {
    private View mErrorView;
    private RecyclerView mRecyclerView;
    private QuestAdapter mQuestAdapter;
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
        //tv_quests = view.findViewById(R.id.text_quests);
        mRecyclerView = view.findViewById(R.id.recycler);
        mErrorView = view.findViewById(R.id.errorView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //tv_quests.setText("Квестс фрагмент");

        mQuestAdapter = new QuestAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mQuestAdapter);

        onRefreshData();
    }

    @Override
    public void showQuests(List<QuestModel> quests) {
        mErrorView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        mQuestAdapter.addData(quests, true);
    }

    @Override
    public void openQuestFragment(int idQuest) {

    }

    @Override
    public void showError() {

    }

    @Override
    public void onItemClick(String username) {

    }

    @Override
    public void onRefreshData() {
        mPresenter.getQuests();
    }
}