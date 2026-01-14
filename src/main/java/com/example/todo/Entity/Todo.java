package com.example.todo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String status;

    public Todo(String title) {
        this.title = title;
        this.status = "TODO";
    }

    public void nextStatus() {
        if(status.equals("TODO")) {
            status = "DOING";
        }
        else if(status.equals("DOING")) {
            status = "DONE";
        }
    }


}
