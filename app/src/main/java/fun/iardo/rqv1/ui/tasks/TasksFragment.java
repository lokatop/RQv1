package fun.iardo.rqv1.ui.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import fun.iardo.rqv1.R;
import fun.iardo.rqv1.common.PresenterFragment;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class TasksFragment extends PresenterFragment implements TasksView {
    private View mErrorView;
    private TextView tv_tasks;

    @InjectPresenter
    TasksPresenter mPresenter;
    @ProvidePresenter
    TasksPresenter providePresenter(){
        return new TasksPresenter();
    }

    public TasksFragment(){}


    public static TasksFragment newInstance(){return new TasksFragment();}

    @Override
    protected TasksPresenter getPresenter() {
        return mPresenter;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tasks,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        tv_tasks = view.findViewById(R.id.text_tasks);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv_tasks.setText("C задачами фрагмент");
    }

}
