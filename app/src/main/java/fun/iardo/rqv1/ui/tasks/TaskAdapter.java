package fun.iardo.rqv1.ui.tasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fun.iardo.rqv1.R;
import fun.iardo.rqv1.data.model.TaskModel;

public class TaskAdapter extends RecyclerView.Adapter<TaskHolder> {

    @NonNull
    private final List<TaskModel> mProjects = new ArrayList<>();
    private final OnItemClickListener mOnItemClickListener;

    public TaskAdapter(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public TaskHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.li_tasks, parent, false);
        return new TaskHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskHolder holder, int position) {
        TaskModel task = mProjects.get(position);
        holder.bind(task, mOnItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mProjects.size();
    }

    public void addData(List<TaskModel> data, boolean isRefreshed) {
        if (isRefreshed) {
            mProjects.clear();
        }
        mProjects.addAll(data);
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {

        void onItemClick(String username);
    }
}
