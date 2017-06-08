package com.sda.todo;

import java.util.List;

/**
 * Created by RENT on 2017-06-08.
 */
public interface ToDoDao {

    List<ToDoModel> getAllToDOs();

    void addToDo(ToDoModel toDoModel);

}
