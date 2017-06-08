package com.sda.todo;

import java.util.List;

/**
 * Created by RENT on 2017-06-08.
 */
public class ToDoViewHtml implements ToDoView {

    @Override
    public String show(List<ToDoModel> todos) {
      StringBuilder stringBuilder = new StringBuilder();
      stringBuilder.append("<ol>");
      todos.stream()
              .map(e -> show(e))
              .forEach(e -> stringBuilder.append(e));
//        for (ToDoModel todo : todos) {
//            stringBuilder.append(show(todo));
//        }
//        stringBuilder.append("</ol>");
        return stringBuilder.toString();
    }

    @Override
    public String show(ToDoModel model) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<li>\n");
        stringBuilder.append("<h3>" + model.getDate().toString() + "</h3>\n");
        stringBuilder.append("<h1>" + model.getName() + "</h1>\n");
        stringBuilder.append("<p>" + model.getDescription() + "</p>\n");
        stringBuilder.append("<p>");
        for (int i = 0; i < model.getPriority(); i ++) {
            stringBuilder.append("X");
        }
        stringBuilder.append("</p>\n");
        stringBuilder.append("</li>\n");
    }
}
