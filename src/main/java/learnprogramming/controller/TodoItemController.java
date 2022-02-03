package learnprogramming.controller;

import learnprogramming.model.TodoData;
import learnprogramming.model.TodoItem;
import learnprogramming.service.TodoItemService;
import learnprogramming.utils.AttributeNames;
import learnprogramming.utils.Mappings;
import learnprogramming.utils.ViewNames;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Slf4j
@Controller
public class TodoItemController {

    //==model attributes==
    @ModelAttribute
    public TodoData todoData(){
        return todoItemService.getData();
    }

    public TodoItemService todoItemService;

    @Autowired
    public TodoItemController(TodoItemService todoItemService) {
        this.todoItemService = todoItemService;
    }

    //http://localhost:8080/doto-list/items
    @GetMapping(Mappings.ITEMS)
    public String items(){
        return ViewNames.ITEMS_LIST;
    }

    //http://localhost:8080/doto-list/add_item
    @GetMapping(Mappings.ADD_ITEM) //paramtry z url są zawsze stringami i Spring je konwertuje
    public String addEditItem(@RequestParam(required = false, defaultValue = "-1") int id, Model model){

        log.info("pobieranie itemu id = {}",id);
        TodoItem todoItem = todoItemService.getItem(id);

        if(todoItem == null){
            todoItem = new TodoItem("", "", LocalDate.now());
        }
            model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
            log.info("dodawanie lub edytowanie itemu. ID = {}", todoItem);

        return ViewNames.ADD_ITEM;
    }

    @PostMapping(Mappings.ADD_ITEM)
    public String processItem(@ModelAttribute(AttributeNames.TODO_ITEM) TodoItem todoItem){
        log.info("procesowanie itemu = {}", todoItem);

        if (todoItem.getId() == 0){
            todoItemService.addItem(todoItem);
        } else {
            todoItemService.updateItem(todoItem);
        }

        return "redirect:/" + Mappings.ITEMS; //redirecting po skończeniu POST na ten adres
    }

    @GetMapping(Mappings.DELETE_ITEM)
    public String deleteItem(@RequestParam("id") int ID){
        todoItemService.removeItem(ID);
        log.info("usuniety item = {}",ID);
        return "redirect:/" + Mappings.ITEMS;
    }

    @GetMapping(Mappings.VIEW_ITEM)
    public String viewItem(@RequestParam int id, Model model){
        log.info("pokazywanie itemu id = {}",id);
        TodoItem todoItem = todoItemService.getItem(id);
        model.addAttribute(AttributeNames.TODO_ITEM, todoItem);
        log.info("dodany do modelu item = {}",todoItem);
        return ViewNames.VIEW_ITEM;
    }

}
