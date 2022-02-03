package learnprogramming.service;

import learnprogramming.model.TodoData;
import learnprogramming.model.TodoItem;

public interface TodoItemService {

    void addItem(TodoItem todoItem);

    void removeItem(int ID);

    TodoItem getItem(int ID);

    void updateItem(TodoItem todoItem);

    TodoData getData();
}
