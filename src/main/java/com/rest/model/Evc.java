package com.rest.model;

import java.util.List;

/**
 * Created by junyuel on 7/19/2016.
 */
public class Evc {
    private String name;
    private String type;
    private int id;
    private List<String> aEnds;
    private List<String> zEnds;

    public Evc() {
    }

    public Evc(String name, String type, int id, List<String> aEnds, List<String> zEnds) {
        this.name = name;
        this.type = type;
        this.id = id;
        this.aEnds = aEnds;
        this.zEnds = zEnds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getaEnds() {
        return aEnds;
    }

    public void setaEnds(List<String> aEnds) {
        this.aEnds = aEnds;
    }

    public List<String> getzEnds() {
        return zEnds;
    }

    public void setzEnds(List<String> zEnds) {
        this.zEnds = zEnds;
    }
}
