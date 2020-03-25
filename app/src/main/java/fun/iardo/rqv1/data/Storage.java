package fun.iardo.rqv1.data;

import java.util.List;


import fun.iardo.rqv1.data.database.RealQuestDao;


public class Storage {

    private RealQuestDao mQuestDao;

    public Storage(RealQuestDao questDao) {
        mQuestDao = questDao;
    }

    public interface StorageOwner {
        Storage obtainStorage();
    }
}
