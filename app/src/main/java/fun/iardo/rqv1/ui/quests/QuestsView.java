package fun.iardo.rqv1.ui.quests;

import fun.iardo.rqv1.common.BaseView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = OneExecutionStateStrategy.class)
public interface QuestsView extends BaseView {
}
