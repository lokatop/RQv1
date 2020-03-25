package fun.iardo.rqv1.ui.quests;

import java.util.List;

import fun.iardo.rqv1.common.BaseView;
import fun.iardo.rqv1.data.model.QuestModel;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = OneExecutionStateStrategy.class)
public interface QuestsView extends BaseView {
    void showQuests(List<QuestModel> projects);
    void openQuestFragment(int idQuest);
}
