package com.sda.todo;

/**
 * Created by RENT on 2017-06-09.
 */
public interface ToDoChainElement {
    boolean isMyResponsibility(String path);

    String action();
}
