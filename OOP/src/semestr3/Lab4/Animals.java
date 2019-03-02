package semestr3.Lab4;

public class Animals implements Nameable{
    protected String name;

    public Animals(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
