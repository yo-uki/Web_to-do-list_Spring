package learnprogramming.service;

import learnprogramming.model.TodoData;
import learnprogramming.model.TodoItem;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class TodoItemServiceImpl implements TodoItemService{

    @Getter //implementuje interface więc nadpisuję metodę getData ale lombok robi dla mnie getter i to też działa
    private final TodoData data = new TodoData();

    @Override
    public void addItem(TodoItem todoItem) {
        data.addItem(todoItem);
    }

    @Override
    public void removeItem(int ID) {
        data.removeItem(ID);
    }

    @Override
    public TodoItem getItem(int ID) {
        return data.getItem(ID);
    }

    @Override
    public void updateItem(TodoItem todoItem) {
        data.updateItem(todoItem);
    }

}
