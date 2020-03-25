package fun.iardo.rqv1.ui.tasks;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import fun.iardo.rqv1.R;
import fun.iardo.rqv1.common.PresenterFragment;
import fun.iardo.rqv1.common.Refreshable;
import fun.iardo.rqv1.data.model.TaskModel;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class TasksFragment extends PresenterFragment implements TasksView,TaskAdapter.OnItemClickListener, Refreshable {
    private View mErrorView;
    private TextView tv_tasks;
    private RecyclerView mRecyclerView;
    private TaskAdapter mTaskAdapter;

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
        //tv_tasks = view.findViewById(R.id.text_tasks);
        mRecyclerView = view.findViewById(R.id.recyclerTasks);
        mErrorView = view.findViewById(R.id.errorView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //tv_tasks.setText("C задачами фрагмент");

        mTaskAdapter = new TaskAdapter(this);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mTaskAdapter);

        onRefreshData();
    }

    @Override
    public void showError() {

    }

    @Override
    public void onRefreshData() {
        mPresenter.getTasks();
    }

    @Override
    public void onItemClick(String username) {

    }

    @Override
    public void showTasks(List<TaskModel> tasks) {
        mErrorView.setVisibility(View.GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        mTaskAdapter.addData(tasks, true);
    }

    @Override
    public void openTaskFragment(int idTask) {

    }
}
