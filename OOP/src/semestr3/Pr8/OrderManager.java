package semestr3.Pr8;

public interface OrderManager {
    int itemsQuantity(String itemName);
    int itemsQuantity(Item item);
    Order[] getOrders();
    int ordersCostSummary();
    int ordersQuantity();
}
