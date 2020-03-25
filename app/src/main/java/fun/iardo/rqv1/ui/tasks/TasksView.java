package fun.iardo.rqv1.ui.tasks;

import java.util.List;

import fun.iardo.rqv1.common.BaseView;
import fun.iardo.rqv1.data.model.TaskModel;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = OneExecutionStateStrategy.class)
public interface TasksView extends BaseView {

    void showTasks(List<TaskModel> projects);
    void openTaskFragment(int idTask);
}
