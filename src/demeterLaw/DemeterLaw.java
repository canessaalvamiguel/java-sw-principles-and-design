package demeterLaw;
/**
* https://devexperto.com/ley-de-demeter/
* https://dev.to/carlillo/demeters-law-dont-talk-to-strangers-10ep
 * https://youtu.be/nfmyz2JlbDk
*
* */
public class DemeterLaw {
    public static void main(String[] args) {
        IAddress address = new Address("1300110", "141", "Cajamarca");
        IHouse house = new House(address, "white");
        IPerson person = new Person("Summer house", house);

        //NO violate the Demeter's Law
        String zipCode = person.getZipCode();

        //NO violate the Demeter's Law
        if(person.isZipCode("565656") ){

        }
    }
}

interface IPerson{
    String getName();
    IHouse getHouse();
    String getZipCode();
    boolean isZipCode(String zipCode);
}

interface IHouse{
    IAddress getAddress();
    String getColor();
    String getZipCode();
}

interface IAddress{
    String getZipCode();
    String getNumber();
    String getStreet();
}

class Person implements IPerson{

    private String name;
    private IHouse house;

    public Person(String name, IHouse house) {
        this.name = name;
        this.house = house;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public IHouse getHouse() {
        return this.house;
    }

    @Override
    public String getZipCode() {
        return this.house.getZipCode();
    }

    @Override
    public boolean isZipCode(String zipCode) {
        return this.getZipCode().equals(zipCode);
    }

}

class House implements IHouse{

    private IAddress address;
    private String color;

    public House(IAddress address, String color) {
        this.address = address;
        this.color = color;
    }

    @Override
    public IAddress getAddress() {
        return this.address;
    }

    @Override
    public String getColor() {
        return this.color;
    }

    @Override
    public String getZipCode() {
        return this.address.getZipCode();
    }

}

class Address implements IAddress{

    private String zipCode;
    private String number;
    private String street;

    public Address(String zipCode, String number, String street) {
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

