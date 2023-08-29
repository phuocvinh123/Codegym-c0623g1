package bai3;

public class Block_C extends Student{
    private int literature;
    private int history;
    private int geography;

    public Block_C(int literature, int history, int geography) {
        this.literature = literature;
        this.history = history;
        this.geography = geography;
    }

    public Block_C(String id, String fullName, String address, String priority, int literature, int history, int geography) {
        super(id, fullName, address, priority);
        this.literature = literature;
        this.history = history;
        this.geography = geography;
    }

    public int getLiterature() {
        return literature;
    }

    public void setLiterature(int literature) {
        this.literature = literature;
    }

    public int getHistory() {
        return history;
    }

    public void setHistory(int history) {
        this.history = history;
    }

    public int getGeography() {
        return geography;
    }

    public void setGeography(int geography) {
        this.geography = geography;
    }

    @Override
    public double average() {
        return (double) (this.literature+this.history+this.geography)/3;
    }

    @Override
    public String toString() {
        return "block_C: " +
                " id= "+getId()+
                ", fullname= "+getFullName()+
                ",  Address= "+getAddress()+
                ", priority= "+getPriority()+
                ", literature= " + literature +
                ", history= " + history +
                ", geography= " + geography +
                ", Average= "+average() ;
    }
}
