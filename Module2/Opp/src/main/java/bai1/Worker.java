package bai1;

public class Worker extends Cadres{
    protected int rank;

    public Worker() {
        super();
    }

    public Worker(int rank) {
        this.rank = rank;
    }

    public Worker(String name, int age, String gender, String address, int rank) {
        super(name, age, gender, address);
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Worker: " + "rank= " + rank +
                ", name= " + name +
                ", age= " + age +
                ", gender= " + gender +
                ", address= " + address ;

    }
}
