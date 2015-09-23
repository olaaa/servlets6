package ru.ferdibiflator.springDemoApplication.entity;

public class Product {
    private int id;
    private String name;
    private double weight;
    private int cost;

    public Product(int id, String name, double weight, int cost) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.cost = cost;
    }

    public int getid() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public int getCost() {
        return cost;
    }
}
