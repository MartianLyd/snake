package com.kryocore.snake.web.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "person" , schema = "" ,catalog = "kryocore")
public class Person {
    private Long id;
    private String name;
    private Integer age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(id, person.id) &&
                Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, name, age);
    }

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Lob
    @Basic(fetch = FetchType.LAZY)
    @Type(type="text")
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "id=" + id + ",name='" + name + "\'" + ",age=" + age;
    }
}
