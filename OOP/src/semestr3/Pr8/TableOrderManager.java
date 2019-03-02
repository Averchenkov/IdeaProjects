package semestr3.Pr8;

import java.util.ArrayList;

public class TableOrderManager implements OrderManager{
    private TableOrder[] orders;
    private final int tablesCount;
    public class OrderAlreadyAddedException extends RuntimeException{
        public OrderAlreadyAddedException(String message) {
            super(message);
        }
    }

    public class InvalidTableNumberException extends  RuntimeException{
        public InvalidTableNumberException(String message){super(message);}
    }


    private void checkTable(int number){
        if(number < 0 || number >= tablesCount){
            throw new InvalidTableNumberException("Table number ");
        }
    }

    public void add(TableOrder order, int tableNumber){
        checkTable(tableNumber);
        if(orders[tableNumber] != null){
            throw new OrderAlreadyAddedException("Table is occupied");
        }else{
            orders[tableNumber] = order;
        }

    }
    public void addItem(Item item, int tableNumber){
        checkTable(tableNumber);
        if(orders[tableNumber] == null){
            throw new InvalidTableNumberException("Table must be occupied");
        }else{
            orders[tableNumber].add(item);
        }
    }

    public int freeTableNumber(){
        for(int i = 0; i < tablesCount; i++){
            if(orders[i] == null){
                return i;
            }
        }
        return -1;
    }
    public int[] freeTableNumbers(){
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i < tablesCount; i++){
            if(orders[i] == null){
                arrayList.add(i);
            }
        }
        int[] arr = new int[arrayList.size()];
        for(int i = 0; i < arr.length; i++){
            arr[i] = arrayList.get(i);
        }
        return arr;
    }

    public Order getOrder(int tableNumber){
        checkTable(tableNumber);
        if(orders[tableNumber] == null){
            throw new InvalidTableNumberException("No order for this table");
        }
        return orders[tableNumber];
    }

    public void remove(int tableNumber){
        checkTable(tableNumber);
        if(orders[tableNumber] == null){
            throw new InvalidTableNumberException("No order for this table");
        }
        orders[tableNumber] = null;
    }
    public void remove(TableOrder order){
        for(int i = 0; i < tablesCount; i++){
            if(orders[i].equals(order)){
                orders[i] = null;
            }
        }
    }






    @Override
    public int itemsQuantity(String itemName) {
        int count = 0;
        for(int i = 0; i < tablesCount; i++){
            if(orders[i] != null){
                count += orders[i].itemsQuantity(itemName);
            }
        }
        return count;
    }

    @Override
    public int itemsQuantity(Item item) {
        int count = 0;
        for(int i = 0; i < tablesCount; i++){
            if(orders[i] != null){
                count += orders[i].itemsQuantity(item);
            }
        }
        return count;
    }

    @Override
    public Order[] getOrders() {
        return orders;
    }

    @Override
    public int ordersCostSummary() {
        int cost = 0;
        for(int i = 0; i < tablesCount; i++){
            if(orders[i] != null){
                cost += orders[i].costTotal();
            }
        }
        return cost;
    }

    @Override
    public int ordersQuantity() {
        int count = 0;
        for(int i = 0; i < tablesCount; i++){
            if(orders[i] != null){
                count ++;
            }
        }
        return count;
    }



    public TableOrderManager(int tablesCount) {
        this.tablesCount = tablesCount;
        orders = new TableOrder[tablesCount];
        for(int i = 0; i < tablesCount; i++){
            orders[i] = null;
        }
    }
}
