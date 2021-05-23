package ru.training.hibernate.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Setter
@Getter

public class Author implements Serializable {

    @Id
    @GeneratedValue(
            strategy= GenerationType.IDENTITY,
            generator="native"
    )

    private long id;
    private String name;

    public Author() {

    }

    public Author(String name) {
        this.name = name;
    }

    public Author(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return id + " : " + name;
    }

    
}
