package com.sda.todo;

import java.util.List;

/**
 * Created by RENT on 2017-06-08.
 */
public interface ToDoView {

    String show(List<ToDoModel> todos);

    String show(ToDoModel model);
}
