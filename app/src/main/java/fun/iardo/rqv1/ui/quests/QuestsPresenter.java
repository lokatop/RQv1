package fun.iardo.rqv1.ui.quests;

import fun.iardo.rqv1.common.BasePresenter;
import fun.iardo.rqv1.utils.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static fun.iardo.rqv1.MainActivity.API_URL;

public class QuestsPresenter extends BasePresenter<QuestsView> {


    public QuestsPresenter(){}

    public void getQuests(){
        mCompositeDisposable.add(ApiService
                .getApiService(API_URL).getQuests("ru")
                //.doOnSuccess()
                //.onErrorReturn()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //.doOnSubscribe()
                //.doFinally()
                .subscribe(
                        response->getViewState().showQuests(response),
                        throwable -> getViewState().showError()
                )
        );
    }
}
