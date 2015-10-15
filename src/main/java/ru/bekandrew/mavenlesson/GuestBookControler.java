package ru.bekandrew.mavenlesson;

import com.sun.prism.impl.Disposer;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by Bek on 15.10.2015.
 */
public interface GuestBookControler {
    void addRecord(String message);
    List<Record> getRecords();
}

class Record{
    int id;
    Timestamp postDate;
    String message;
    Record(int id, Timestamp postDate, String message ){
        this.id = id;
        this.postDate = postDate;
        this.message = message;
    }
}

