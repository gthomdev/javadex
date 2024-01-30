package com.gthomdev.model;

public class Pokemon {
    public String id;
    public String name;

    public Pokemon() {

    }
    public Pokemon(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
