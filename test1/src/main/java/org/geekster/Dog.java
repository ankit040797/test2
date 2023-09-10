package org.geekster;

public class Dog {
    private String name = "Doggy";

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Dog [name=" + name + "]";
    }
}
