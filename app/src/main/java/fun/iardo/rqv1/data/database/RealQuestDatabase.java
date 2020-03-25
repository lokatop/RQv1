package fun.iardo.rqv1.data.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import fun.iardo.rqv1.data.model.QuestModel;
import fun.iardo.rqv1.data.model.TaskModel;

@Database(entities = {TaskModel.class, QuestModel.class}, version = 1)
public abstract class RealQuestDatabase extends RoomDatabase {
    public abstract RealQuestDao getReqlQuestDao();
}
