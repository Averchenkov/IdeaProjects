package semestr3.Pr8;

import java.util.ArrayList;


public class InternetOrderManager implements OrderManager{
    private ArrayList<InternetOrder> list;

    public InternetOrderManager() {
        list = new ArrayList<>();
    }

    public boolean add(InternetOrder order){
        if(!list.contains(order)){
            list.add(order);
            return true;
        }else{
            return false;
        }
    }

    public void remove(InternetOrder order){
        if(list.contains(order)){
            list.remove(order);
        }
    }

    public void remove(String address){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getCustomer().getAddress().equals(address)){
                list.remove(i);
                return;
            }
        }
    }

    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            count += list.get(i).itemsQuantity(itemName);
        }
        return count;
    }

    @Override
    public int itemsQuantity(Item item) {
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            count += list.get(i).itemsQuantity(item);
        }
        return count;
    }

    @Override
    public Order[] getOrders() {
        Order[] orders = new Order[list.size()];

        return list.toArray(orders);
    }

    @Override
    public int ordersCostSummary() {
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            count += list.get(i).costTotal();
        }
        return count;
    }

    @Override
    public int ordersQuantity() {
        return list.size();
    }
}
