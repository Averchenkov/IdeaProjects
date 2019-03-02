package semestr3.Pr8;

public class Address {
    private final String cityName;
    private final int zipCode;
    private final String streetName;
    private final int buildingNumber;
    private final char buildingLetter;
    private final int apartmentNumber;
    public static final Address EMPTY_ADDRESS = new Address();

    public Address() {
        this.cityName = "";
        this.zipCode = -1;
        this.streetName = "";
        this.buildingNumber = -1;
        this.buildingLetter = 'a';
        this.apartmentNumber = -1;
    }

    public Address(String streetName, int buildingNumber, char buildingLetter, int apartmentNumber) {
        this.cityName = "Moscow";
        this.zipCode = 1;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = apartmentNumber;
    }

    public Address(String cityName, int zipCode, String streetName, int buildingNumber, char buildingLetter, int appartmentNumber) {
        this.cityName = cityName;
        this.zipCode = zipCode;
        this.streetName = streetName;
        this.buildingNumber = buildingNumber;
        this.buildingLetter = buildingLetter;
        this.apartmentNumber = appartmentNumber;
    }

    public String getCityName() {
        return cityName;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getBuildingNumber() {
        return buildingNumber;
    }

    public char getBuildingLetter() {
        return buildingLetter;
    }

    public int getAppartmentNumber() {
        return apartmentNumber;
    }
}
