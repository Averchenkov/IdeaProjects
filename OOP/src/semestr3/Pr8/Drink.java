package semestr3.Pr8;

public class Drink implements Item, Alcoholable{
        private final String name;
        private final double cost;
        private final String description;
        private final DrinkTypeEnum type;
        private double alcoholVol;
    public Drink(String name, double cost, String description, DrinkTypeEnum type, double alcoholVol) {
        this.name = name;
        this.cost = cost;
        this.description = description;
        this.type = type;
        this.alcoholVol = alcoholVol;
    }

    @Override
    public boolean isAlcoholicDrink() {
        return alcoholVol > 0;
    }

    @Override
    public double getAlcoholVol() {
        return alcoholVol;
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
    public DrinkTypeEnum getType(){
        return type;
    }
}
