package fun.iardo.rqv1.ui.quests;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import fun.iardo.rqv1.R;
import fun.iardo.rqv1.data.model.QuestModel;

public class QuestHolder extends RecyclerView.ViewHolder {

    private TextView mName;
    private TextView mDescription;
    private TextView mTask;

    public QuestHolder(View itemView) {
        super(itemView);
        mName = itemView.findViewById(R.id.tv_name);
        mDescription = itemView.findViewById(R.id.tv_description);
        mTask = itemView.findViewById(R.id.tv_tasks);
    }

    public void bind(QuestModel item, QuestAdapter.OnItemClickListener onItemClickListener) {

        mName.setText(item.getName());
        mDescription.setText(item.getDescription());
        mTask.setText(item.getTasks());

        if (onItemClickListener != null) {
            itemView.setOnClickListener(v -> onItemClickListener.onItemClick(
                    String.valueOf(item.getId())
            ));
        }
    }
}
