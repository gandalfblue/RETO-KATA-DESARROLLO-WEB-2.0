package com.sofka.university.Crud_Springboot.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Clase que representa a la identidad Todo, cuya tabla se crea en la base de datos
 */
@Entity
@Getter @Setter @ToString
@Table(name = "Todo")
public class Todo {

    /**
     * Atributo que representa a la columna id de la base de datos
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Atributo que representa a la columna name de la base de datos
     */
    @Column(name = "name")
    private String name;

    /**
     * Atributo que representa a la columna isCompleted de la base de datos
     */
    @Column(name = "isCompleted")
    private Boolean isCompleted;

    /**
     * Metodo que representa al constructor vacio.
     */
    public Todo() {
    }

    /**
     * Metodo que representa al constructor que inicializa los atributos name e isCompleted
     * @param name
     * @param isCompleted
     */
    public Todo(String name, Boolean isCompleted) {
        this.name = name;
        this.isCompleted = isCompleted;
    }
}
