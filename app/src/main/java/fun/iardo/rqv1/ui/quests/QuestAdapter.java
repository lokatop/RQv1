package fun.iardo.rqv1.ui.quests;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import fun.iardo.rqv1.R;
import fun.iardo.rqv1.data.model.QuestModel;

public class QuestAdapter extends RecyclerView.Adapter<QuestHolder> {

    @NonNull
    private final List<QuestModel> mProjects = new ArrayList<>();
    private final OnItemClickListener mOnItemClickListener;

    public QuestAdapter(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public QuestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.li_quests, parent, false);
        return new QuestHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuestHolder holder, int position) {
        QuestModel quest = mProjects.get(position);
        holder.bind(quest, mOnItemClickListener);
    }

    @Override
    public int getItemCount() {
        return mProjects.size();
    }

    public void addData(List<QuestModel> data, boolean isRefreshed) {
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
