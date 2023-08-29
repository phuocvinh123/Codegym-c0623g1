package bai8;

import java.util.List;

public class LoanCard extends Student{
    private String id;
    private String BorrowedDate;
    private String DateDue;
    private int number;

    public LoanCard(String id, String borrowedDate, String dateDue, int number) {
        this.id = id;
        BorrowedDate = borrowedDate;
        DateDue = dateDue;
        this.number = number;
    }

    public LoanCard(String name, int age, String class1, String id, String borrowedDate, String dateDue, int number) {
        super(name, age, class1);
        this.id = id;
        BorrowedDate = borrowedDate;
        DateDue = dateDue;
        this.number = number;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBorrowedDate() {
        return BorrowedDate;
    }

    public void setBorrowedDate(String borrowedDate) {
        BorrowedDate = borrowedDate;
    }

    public String getDateDue() {
        return DateDue;
    }

    public void setDateDue(String dateDue) {
        DateDue = dateDue;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "LoanCard:" +
                " name= '" + getName() + '\'' +
                ", age= " + getAge() +
                ", class1= '" + getClass1() + '\''+
                " id= '" + id + '\'' +
                ", BorrowedDate= '" + BorrowedDate + '\'' +
                ", DateDue= '" + DateDue + '\'' +
                ", number= " + number ;
    }
}
