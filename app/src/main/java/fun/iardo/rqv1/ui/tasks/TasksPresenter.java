package fun.iardo.rqv1.ui.tasks;

import fun.iardo.rqv1.common.BasePresenter;
import fun.iardo.rqv1.utils.ApiService;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

import static fun.iardo.rqv1.MainActivity.API_URL;

public class TasksPresenter extends BasePresenter<TasksView>{
    public TasksPresenter(){}

    public void getTasks(){
        mCompositeDisposable.add(ApiService
                .getApiService(API_URL).getTasks("ru")
                //.doOnSuccess()
                //.onErrorReturn()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                //.doOnSubscribe()
                //.doFinally()
                .subscribe(
                        response->getViewState().showTasks(response),
                        throwable -> getViewState().showError()
                )
        );
    }
}
