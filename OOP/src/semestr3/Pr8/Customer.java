package semestr3.Pr8;

public class Customer {
 private final String firstName;
 private final String secondName;
 private final int age;
 private final Address address;
 public static final Customer MATURE_UNKNOWN_CUSTOMER = new Customer(21);
 public static final Customer NOT_MATURE_UNKNOWN_CUSTOMER = new Customer(14);
    public Customer(String firstName, String secondName, int age, Address address) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.address = address;
    }

    public Customer() {
        this.firstName = "";
        this.secondName = "";
        this.age = -1;
        this.address = Address.EMPTY_ADDRESS;
    }

    public Customer(int age) {
        this.firstName = "";
        this.secondName = "";
        this.age = age;
        this.address = Address.EMPTY_ADDRESS;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }
}
