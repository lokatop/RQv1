package fun.iardo.rqv1.data.api;

import java.util.List;

import fun.iardo.rqv1.data.model.QuestModel;
import fun.iardo.rqv1.data.model.TaskModel;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface IRealQuestsApi {

    @GET("api/v1/quests")
    Single<List<QuestModel>> getQuests(@Query("language") String language);

    @GET("api/v1/quests/{id}")
    Single<QuestModel> getOneQuest(@Path("id") Integer cityKey, @Query("language") String language);

    @GET("api/v1/tasks")
    Single<List<TaskModel>> getTasks(@Query("language") String language);

    @GET("api/v1/tasks/{id}")
    Single<TaskModel> getOneTask(@Path("id") Integer cityKey, @Query("language") String language);

}
