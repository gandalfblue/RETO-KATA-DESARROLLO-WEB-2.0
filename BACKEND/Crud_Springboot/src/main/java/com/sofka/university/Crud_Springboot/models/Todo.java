package com.sofka.university.Crud_Springboot.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/*
    Clase que refleja a la identidad Todo de la base de datos
 */
@Entity
@Getter @Setter @ToString
@Table(name = "Todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "isCompleted")
    private Boolean isCompleted;

    public Todo() {
    }

    public Todo(String name, Boolean isCompleted) {
        this.name = name;
        this.isCompleted = isCompleted;
    }
}
