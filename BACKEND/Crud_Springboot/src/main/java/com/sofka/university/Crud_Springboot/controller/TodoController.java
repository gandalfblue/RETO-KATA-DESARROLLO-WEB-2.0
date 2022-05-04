package com.sofka.university.Crud_Springboot.controller;

import com.sofka.university.Crud_Springboot.models.Todo;
import com.sofka.university.Crud_Springboot.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


/*
 Clase que representa el controlador del backend y se especifican como van a salir los enpoints hacia el front
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class TodoController {

    @Autowired
    private TodoService todoService;

//    @GetMapping(value = "/todolist")
//    public ResponseEntity<List<Todo>> list(Long id) {
//        return todoService.getAllTodo(id);
//    }//
//
//    @PostMapping(value = "/todo")
//    public ResponseEntity<Todo> save(@RequestBody Todo todo) {
//        return todoService.createTodo(todo);
//    }//
//
//    @PutMapping(value = "/todo")
////    public Todo save(@RequestBody Todo todo){
//        if(todo.get(id) != null){
//            return todoService.save(todo);
//        }
//        throw new RuntimeException("No existe el id para actualizar");
////    }//
//
//    @DeleteMapping(value = "/{id}/todo")
//    public void delete(@PathVariable("id") Long id) {
//        todoService.deleteTodoById(id);
//    }//
//
//    @GetMapping(value = "/{id}/todo")
//    public ResponseEntity<Todo> get(@PathVariable("id") Long id) {
//        return todoService.getTodoById(id);
//    }

    /*
       Metodo que sirve para enrutarme a la clase service para obtener un get de todos los Todos.
   */
    @GetMapping(value = "/todolist")
    public ResponseEntity<List<Todo>> getAllTodo(@RequestParam(required = false) Long id) {
        try {
            List<Todo> todoList = new ArrayList<>();

            if (id == null) {
                todoService.list().forEach(todoList::add);
            }

            if (todoList.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(todoList, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /*
         Metodo que sirve para enrutarme a la clase service para guardar un Todo
    */
    @PostMapping(value = "/todo")
    public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {
        try {
            Todo _todo = todoService.save(todo);
            return new ResponseEntity<>(_todo, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
        }
    }

    /*
        Metodo que sirve para enrutarme a la clase service para borrar un solo Todo mediante el id.
    */
    @DeleteMapping(value = "/{id}/todo")
    public ResponseEntity<String> deleteTodoById(@PathVariable("id") Long id) {
        try {
            todoService.delete(id);
            return new ResponseEntity<>("Todo DELETE!! ", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }

    /*
        Metodo que sirve para enrutarme a la clase service para obtener un get de un solo T odo mediante el id.
    */
    @GetMapping(value = "/{id}/todo")
    public ResponseEntity<Todo> getTodoById(@PathVariable("id") Long id) {
        Optional<Todo> todo = Optional.ofNullable(todoService.get(id));

        if (todo.isPresent()) {
            return new ResponseEntity<>(todo.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /*
        Metodo que sirve para enrutarme a la clase service para actualizar un solo Todo mediante el id.
    */
    @PutMapping(value = "/todo")
    public ResponseEntity<Todo> updateTodo(@RequestBody Todo todo) {
        if (todo.getId() != null) {
            return new ResponseEntity<>(todoService.saveUpdate(todo), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
    }
}

