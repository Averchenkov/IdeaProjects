package semestr3.Pr8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.ListIterator;

public class InternetOrder implements Order {
    private DoubleList list;
    private Customer customer;
    public InternetOrder(Customer customer) {
        list = new DoubleList();
        this.customer = customer;
    }



    @Override
    public boolean add(Item i) {
        return list.add(i);
    }

    @Override
    public boolean remove(String name) {

        return list.removeByName(name);
    }

    @Override
    public int removeAll(String name) {
        int counter = -1;
        do{

            counter++;
        }while(list.removeByName(name));
        return counter;
    }

    @Override
    public int itemsQuantity() {
        return list.size();
    }

    @Override
    public Item[] getItems() {
        return (Item[])list.toArray();
    }

    @Override
    public double costTotal() {
        ListIterator<Item> it = list.listIterator();
        if(list.isEmpty()){
            return 0;
        }
        int cost = 0;
        do{
            cost += it.next().getCost();
        }while(it.hasNext());
        return cost;
    }

    @Override
    public int itemsQuantity(String name) {
        ListIterator<Item> it = list.listIterator();
        if(list.isEmpty()){
            return 0;
        }
        int count = 0;
        do{
            if(it.next().getName().equals(name)){
                count++;
            }
        }while(it.hasNext());
        return  count;

    }

    @Override
    public String[] itemsNames() {
        if(list.isEmpty()){
            return new String[0];
        }
        ListIterator<Item> it = list.listIterator();
        ArrayList<String> arr = new ArrayList<>(list.size());
        do{
            arr.add(it.next().getName());
        }while(it.hasNext());
        String[] string = new String[arr.size()];
        for(int i = 0; i < arr.size(); i++){
            string[i] = arr.get(i);
        }
        return string;
    }

    @Override
    public Item[] sortedItemsByCost() { // FIXXX
        ArrayList<Item> arr = new ArrayList<>(list);
        arr.sort(new Comparator<Item>() {
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
        return  (Item[]) (arr.toArray());
    }

    @Override
    public int itemsQuantity(Item item) {
        ListIterator<Item> iterator = list.listIterator();
        int count = 0;
        if(list.isEmpty()){
            return 0;
        }
        do{
            if(iterator.next().equals(item)){
                count ++;
            }
        }while(iterator.hasNext());
        return count;
    }

    @Override
    public boolean remove(Item item) {
        boolean flag = false;
        if(list.isEmpty()){
            return flag;
        }
        ListIterator<Item> it = list.listIterator();
        do{
            if(it.next().equals(item)){
                flag = true;
                it.remove();
            }
        }while(!flag && it.hasNext());
        return flag;
    }

    @Override
    public int removeAll(Item item) {
        int count = 0;
        if(list.isEmpty()){
            return count;
        }
        ListIterator<Item> it = list.listIterator();
        do{
            if(it.next().equals(item)){
                it.remove();
                count++;
            }
        }while(it.hasNext() && !list.isEmpty());
        return count;
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
