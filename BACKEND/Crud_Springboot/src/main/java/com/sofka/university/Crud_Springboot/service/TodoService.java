package com.sofka.university.Crud_Springboot.service;

import com.sofka.university.Crud_Springboot.models.Todo;
import com.sofka.university.Crud_Springboot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    Clase que representa los servicios crud para la entidad Todo
 */
@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    /*
        Metodo que sirve para obtener todos los Todos que estan almacenados en la base de datos
     */
    public Iterable<Todo> list(){
        return todoRepository.findAll();
    }

    /*
        Metodo que sirve para guardar un Todo en la base de datos
     */
    public Todo save(Todo todo){
        return todoRepository.save(new Todo(todo.getName(), todo.getIsCompleted()));
    }

    public Todo saveUpdate(Todo todo){
        return todoRepository.save(todo);
    }

    /*
        Metodo que me permite eliminar un solo Todo por medio del id en la base de datos.
     */
    public void delete(Long id){
        todoRepository.delete(get(id));
    }

    /*
        Metodo que sirve para obtener un solo Todo que estan almacenado en la base de datos
     */
    public Todo get(Long id){
        return todoRepository.findById(id).orElseThrow();
    }
}
