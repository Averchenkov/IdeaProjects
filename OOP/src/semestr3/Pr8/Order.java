package semestr3.Pr8;

public interface Order {
    boolean add(Item i);
    String[] itemsNames();
    int itemsQuantity();
    int itemsQuantity(String name);
    int itemsQuantity(Item item);
    Item[] getItems();
    boolean remove(String name);
    boolean remove(Item item);
    int removeAll(String name);
    int removeAll(Item item);
    Item[] sortedItemsByCost();
    double costTotal();
    Customer getCustomer();
    void setCustomer(Customer customer);
}
