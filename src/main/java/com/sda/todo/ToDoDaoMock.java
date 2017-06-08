package com.sda.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by RENT on 2017-06-08.
 */
public class ToDoDaoMock implements ToDoDao {


    private List<ToDoModel> todos;

    public ToDoDaoMock() {
        todos = new ArrayList<>();

        init();
    }

    @Override
    public List<ToDoModel> getAllToDOs() {
        return todos;
    }

    @Override
    public void addToDo(ToDoModel toDoModel) {
        todos.add(toDoModel);

    }

    private void init() {
        todos.add(new ToDoModel("Zadanie domowe", "Do zrobienia zd nr 1 ze str 10", false, 5, LocalDate.now()));
        todos.add(new ToDoModel("Spotkanie z Tomkiem", "Idziemy na kregle", false, 3, LocalDate.now().minusDays(5)));
        todos.add(new ToDoModel("Zakupy", "2 pomarancze i papier toaletowy", false, 5, LocalDate.now().plusDays(4)));
    }
}
