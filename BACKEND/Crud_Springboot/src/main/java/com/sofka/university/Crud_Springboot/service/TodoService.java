package com.sofka.university.Crud_Springboot.service;

import com.sofka.university.Crud_Springboot.models.Todo;
import com.sofka.university.Crud_Springboot.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Clase que representa los servicios crud para la entidad Todo
 */
@Service
public class TodoService {

    /**
     * Objeto que representa a la clase TodoRepository
     */
    @Autowired
    private TodoRepository todoRepository;

    /**
     * Metodo que sirve para obtener todos los Todos que estan almacenados en la base de datos
     * @return Una lista con todos los Todos
     */
    public Iterable<Todo> list(){
        return todoRepository.findAll();
    }

    /**
     *  Metodo que sirve para guardar un Todo en la base de datos
     * @param todo
     * @return Guarda nuevo objeto en la base de datos
     */
    public Todo save(Todo todo){
        return todoRepository.save(new Todo(todo.getName(), todo.getIsCompleted()));
    }

    /**
     * Metodo que sirve para guardar un Todo por medio del id en la base de datos
     * @param todo
     * @return Actualiza un Todo en la base de datos
     */
    public Todo saveUpdate(Todo todo){
        return todoRepository.save(todo);
    }

    /**
     * Metodo que me permite eliminar un solo Todo por medio del id en la base de datos.
     * @param id
     */
    public void delete(Long id){
        todoRepository.delete(get(id));
    }

    /**
     * Metodo que sirve para obtener un solo Todo que estan almacenado en la base de datos
     * @param id
     * @return Un solo objeto desde la base de datos, de acuerdo al id que se le halla ingresado
     */
    public Todo get(Long id){
        return todoRepository.findById(id).orElseThrow();
    }
}
