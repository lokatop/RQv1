package fun.iardo.rqv1.ui.tasks;

import fun.iardo.rqv1.common.BaseView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = OneExecutionStateStrategy.class)
public interface TasksView extends BaseView {
}
