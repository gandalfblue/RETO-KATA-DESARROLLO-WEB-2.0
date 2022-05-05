package com.sofka.university.Crud_Springboot.repository;

import com.sofka.university.Crud_Springboot.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Representa a un interfaz que hereda de la interfaz CrudRepository que tiene SpringBoot, todos sus metodos
 */
@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
