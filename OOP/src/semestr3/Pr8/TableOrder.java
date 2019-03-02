package semestr3.Pr8;

import java.util.ArrayList;
import java.util.Comparator;

public class TableOrder implements Order{
    ArrayList<Item> list;
    Customer customer;

    public TableOrder(Customer customer) {
        this.customer = customer;
        list = new ArrayList<>();
    }

    @Override
    public boolean add(Item i) {
        list.add(i);
        return true;
    }

    @Override
    public String[] itemsNames() {
        String[] line = new String[list.size()];
        for(int i =0 ; i < list.size(); i++){
            line[i] = list.get(i).toString();
        }
        return line;
    }

    @Override
    public int itemsQuantity() {
        return list.size();
    }

    @Override
    public int itemsQuantity(String name) {
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equals(name)){
                count++;
            }
        }
        return count;
    }

    @Override
    public int itemsQuantity(Item item) {
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(item)){
                count++;
            }
        }
        return count;
    }

    @Override
    public Item[] getItems() {
        return list.toArray(new Item[list.size()]);
    }

    @Override
    public boolean remove(String name) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equals(name)){
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean remove(Item item) {
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(item)){
                list.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public int removeAll(String name) {
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getName().equals(name)){
                list.remove(i);
                count++;
                i--;
            }
        }
        return count;
    }

    @Override
    public int removeAll(Item item) {
        int count = 0;
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(item)){
                list.remove(i);
                count++;
                i--;
            }
        }
        return count;
    }

    @Override
    public Item[] sortedItemsByCost() {
        ArrayList<Item> newList = new ArrayList<>(list);
        newList.sort(new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2) {
                if(o1.getCost() > o2.getCost()){
                    return -1;
                }else if(o1.getCost() < o2.getCost()){
                    return 1;
                }else{
                    return 0;
                }
            }
        });
        return newList.toArray(new Item[newList.size()]);
    }

    @Override
    public double costTotal() {
        int cost = 0;
        for(int i = 0; i < list.size(); i++){
            cost += list.get(i).getCost();
        }
        return cost;
    }

    @Override
    public Customer getCustomer() {
        return customer;
    }

    @Override
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
