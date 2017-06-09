package com.sda.todo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by RENT on 2017-06-09.
 */
public class ToDoChain {
    private List<ToDoChainElement> chainElements;

    private ToDoView toDoView;

    private ToDoDao toDoDao;

    public ToDoChain(ToDoView toDoView, ToDoDao toDoDao) {
        this.chainElements = new ArrayList<>();
        this.toDoView = toDoView;
        this.toDoDao = toDoDao;
        init();
    }

    public String invoke(String path) {
        Iterator<ToDoChainElement> iterator = chainElements.iterator();
        ToDoChainElement finalElement = null;
        boolean flag = false;
        while (!flag && iterator.hasNext()) {
            ToDoChainElement next = iterator.next();
            if (next.isMyResponsibility(path)) {
                finalElement = next;
                flag = true;
            }
        }
//        String result = null;
//        if (finalElement == null) {
//            result= "<h1>Cannot find page</h>";
//        }
//        return result;
            return finalElement != null ? finalElement.action() : "<h1>cannot find page</h1>";
     }

    private void init() {
        chainElements.add(new AllToDosChainElement("/all", toDoDao, toDoView));
    }
}

