package fun.iardo.rqv1.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class QuestResponse implements Serializable {

    @SerializedName("quests")
    private List<QuestModel> mQuests;

    public List<QuestModel> getQuests() {
        return mQuests;
    }

    public void setProjects(List<QuestModel> quests) {
        mQuests = quests;
    }
}
