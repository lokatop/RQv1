package fun.iardo.rqv1.ui.home;

import fun.iardo.rqv1.common.BaseView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = OneExecutionStateStrategy.class)
public interface HomeView extends BaseView {
    void showData();
}
