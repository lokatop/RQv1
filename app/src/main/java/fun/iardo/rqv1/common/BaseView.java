package fun.iardo.rqv1.common;

import moxy.MvpView;
import moxy.viewstate.strategy.OneExecutionStateStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = OneExecutionStateStrategy.class)
public interface BaseView extends MvpView {
    //void showRefresh();
    //void hideRefresh();
    //void showError();

}
