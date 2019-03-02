package semestr3.Pr8;

public class Main {
    public static void main(String[] args) {
        TableOrderManager manager = new TableOrderManager(9);
        TableOrder t1 = new TableOrder(new Customer(20));
        t1.add(new Drink("Сок", 200, "Яблочный сок", DrinkTypeEnum.JUICE, 2));
        manager.add(t1, 5);
        System.out.println("Стол 5 ");
        System.out.println("Количесвто сока " + manager.itemsQuantity("Сок"));
        System.out.println("Счет за сок " + manager.ordersCostSummary());
        TableOrder t2 = new TableOrder(new Customer(29));
        t2.add(new Drink("Вино", 120, "1 бокал вина", DrinkTypeEnum.WINE, 30));
       // manager.add(t1, 5);
        manager.add(t2, 8);
        int[] tables = manager.freeTableNumbers();
        System.out.println("Свободные столы:");
        for(int i = 0; i < tables.length; i++){
            System.out.println(tables[i]);
        }

        manager.remove(5);
        System.out.println("Количество сока " + manager.itemsQuantity("Сок"));
        manager.addItem(new Drink("Виски", 240, "Виски со лдом", DrinkTypeEnum.WHISKEY, 50),8);
        System.out.println("Счет за виски и вино " + manager.ordersCostSummary());

    }
}
