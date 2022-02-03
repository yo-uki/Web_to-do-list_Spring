package learnprogramming.model;

import lombok.NonNull;

import java.time.LocalDate;
import java.util.*;

public class TodoData {

    //==fields==
    private static int idValue = 1;

    private final List<TodoItem> items = new ArrayList<>();

    //==constructors==
    public TodoData() {

        addItem(new TodoItem("first", "first details", LocalDate.now()));
        addItem(new TodoItem("second", "second details", LocalDate.now()));
        addItem(new TodoItem("third", "third details", LocalDate.now()));
        addItem(new TodoItem("fourth", "fourth details", LocalDate.now()));
    }

    //==public methods==

    public List<TodoItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public void  addItem(@NonNull TodoItem toAdd){

        toAdd.setId(idValue);
        items.add(toAdd);
        idValue++;

    }

    public void removeItem(int id){
        ListIterator<TodoItem> iterator = items.listIterator();

        while (iterator.hasNext()){
            TodoItem item = iterator.next();

            if (item.getId() == id){
                iterator.remove();;
                break;
            }
        }
    }

    public TodoItem getItem(int id){
        for (TodoItem item : items){
            if ((item.getId() == id))
                return item;
        }
        return null;
    }

    public void updateItem(@NonNull TodoItem toUpdate){
        ListIterator<TodoItem> iterator = items.listIterator();

        while (iterator.hasNext()){
            TodoItem item = iterator.next();

            if (item.equals(toUpdate)){
                iterator.set(toUpdate);
                break;
            }
        }
    }
}
