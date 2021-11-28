package com.example.challenge.restservice;

public class Bisection {
    private final long id;
    private final double root;

    public Bisection(long id, double root) {
        this.id = id;
        this.root = root;
    }

    public long getId() {
        return id;
    }

    public double getRoot() {
        return root;
    }
}
