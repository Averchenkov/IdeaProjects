package semestr3.Pr8;

public class Dish implements Item {
    private final String name;
    private final int cost;
    private final String description;
    private final int NULL = 0;
    public Dish(String name, String description) {
        this.name = name;
        this.description = description;
        cost = NULL;
    }

    public Dish(String name, int cost, String description) {
        this.name = name;
        this.cost = cost;
        this.description = description;
    }
    @Override
    public String getName() {
        return name;
    }
    @Override
    public double getCost() {
        return cost;
    }
    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " " + cost + " : " + description;
    }
}
