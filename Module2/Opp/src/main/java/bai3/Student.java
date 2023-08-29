package bai3;

public abstract class Student {
    private String id;
    private String fullName;
    private String Address;
    private String priority;

    public Student() {
    }

    public Student(String id, String fullName, String address, String priority) {
        this.id = id;
        this.fullName = fullName;
        Address = address;
        this.priority = priority;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getPriority() {
        String str="";
        switch (priority){
            case "1":
                str="kv1";
                break;
            case "2":
                str="kv2";
                break;
            case "3":
                str="kv3";
                break;
            case "4":
                str="kv4";
                break;
        }
        return str;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public abstract double average() ;

    @Override
    public String toString() {
        return "Student: " +
                " id= '" + id + '\'' +
                ", fullName= '" + fullName + '\'' +
                ", Address= '" + Address + '\'' +
                ", priority= '" + priority + '\'' ;
    }
}
