package fun.iardo.rqv1.ui.tasks;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import fun.iardo.rqv1.R;
import fun.iardo.rqv1.data.model.QuestModel;
import fun.iardo.rqv1.data.model.TaskModel;


/**
 * Created by Vladislav Falzan.
 */

public class TaskHolder extends RecyclerView.ViewHolder {

    private TextView mName;
    private TextView mTask;

    public TaskHolder(View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.tv_name_tasks);
        mTask = itemView.findViewById(R.id.tv_task);
    }

    public void bind(TaskModel item, TaskAdapter.OnItemClickListener onItemClickListener) {

        mName.setText(item.getName());
        mTask.setText(item.getTask());

        if (onItemClickListener != null) {
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(
                    String.valueOf(item.getId())
            ));
        }
    }
}
