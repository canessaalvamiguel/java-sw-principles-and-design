package demeterLaw;

public class NoDemeterLaw {
    public static void main(String[] args) {
        IAddress_ address = new Address_("1300110", "141", "Cajamarca");
        IHouse_ house = new House_(address, "white");
        IPerson_ person = new Person_("Summer house", house);

        //Violated the Demeter's Law
        String zipCode =
                person
                .getHouse()
                .getAddress()
                .getZipCode();

        //Violated the Demeter's Law
        if(person
                .getHouse()
                .getAddress()
                .getZipCode() == "565656"){

        }
    }
}

interface IPerson_ {
    String getName();
    IHouse_ getHouse();
}

interface IHouse_ {
    IAddress_ getAddress();
    String getColor();
}

interface IAddress_ {
    String getZipCode();
    String getNumber();
    String getStreet();
}

class Person_ implements IPerson_ {

    private String name;
    private IHouse_ house;

    public Person_(String name, IHouse_ house) {
        this.name = name;
        this.house = house;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public IHouse_ getHouse() {
        return this.house;
    }

}

class House_ implements IHouse_ {

    private IAddress_ address;
    private String color;

    public House_(IAddress_ address, String color) {
        this.address = address;
        this.color = color;
    }

    @Override
    public IAddress_ getAddress() {
        return this.address;
    }

    @Override
    public String getColor() {
        return this.color;
    }

}

class Address_ implements IAddress_ {

    private String zipCode;
    private String number;
    private String street;

    public Address_(String zipCode, String number, String street) {
        this.zipCode = zipCode;
        this.number = number;
        this.street = street;
    }

    @Override
    public String getZipCode() {
        return this.zipCode;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public String getStreet() {
        return this.street;
    }
}
