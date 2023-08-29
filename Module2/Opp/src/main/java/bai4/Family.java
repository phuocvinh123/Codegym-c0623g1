package bai4;

import java.util.List;

public class Family {
   private List<Person>person;
   private String Address;

    public Family(List<Person> person, String address) {
        this.person = person;
        Address = address;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    @Override
    public String toString() {
        return "Family: " +
                " person= " + person +
                ", Address= '" + Address + '\'' ;
    }
}
