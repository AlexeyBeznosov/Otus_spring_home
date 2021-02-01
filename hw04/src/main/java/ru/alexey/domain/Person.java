package ru.alexey.domain;

import java.util.Objects;

public class Person {
    private String name;
    private String secondname;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondname() {
        return secondname;
    }

    public void setSecondname(String secondname) {
        this.secondname = secondname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return name.equals(person.name) &&
                secondname.equals(person.secondname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, secondname);
    }
}
