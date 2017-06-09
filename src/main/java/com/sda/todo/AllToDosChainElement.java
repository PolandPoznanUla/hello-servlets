package com.sda.todo;

import java.util.List;

/**
 * Created by RENT on 2017-06-09.
 */
public class AllToDosChainElement implements  ToDoChainElement {

    private String path;

    private ToDoDao toDoDao;

    private  ToDoView toDoView;

    public AllToDosChainElement(String path, ToDoDao toDoDao, ToDoView toDoView) {
        this.path = path;
        this.toDoDao = toDoDao;
        this.toDoView = toDoView;
    }

    @Override
    public boolean isMyResponsibility(String path) {
        return this.path.equals(path);
    }

    @Override
    public String action() {
        List<ToDoModel> allToDos = toDoDao.getAllToDOs();
        return toDoView.show(allToDos);
    }
}
