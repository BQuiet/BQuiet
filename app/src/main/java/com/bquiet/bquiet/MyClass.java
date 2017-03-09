package com.bquiet.bquiet;

public class MyClass {
    private String className;

    public MyClass(String name) {
        this.className = name;
    }

    public MyClass() {
    }

    public String getName() {
        return className;
    }

    public void setName(String name) {
        this.className = name;
    }
}
