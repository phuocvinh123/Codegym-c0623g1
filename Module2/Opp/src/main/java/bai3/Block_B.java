package bai3;

public class Block_B extends Student{
    private int maths;
    private int chemistry;
    private int biology;

    public Block_B(int maths, int chemistry, int biology) {
        this.maths = maths;
        this.chemistry = chemistry;
        this.biology = biology;
    }

    public Block_B(String id, String fullName, String address, String priority, int maths, int chemistry, int biology) {
        super(id, fullName, address, priority);
        this.maths = maths;
        this.chemistry = chemistry;
        this.biology = biology;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    public int getBiology() {
        return biology;
    }

    public void setBiology(int biology) {
        this.biology = biology;
    }

    @Override
    public double average() {
        return (double) (this.maths + this.chemistry+this.biology) /3;
    }

    @Override
    public String toString() {
        return "block_B: " +
                " id= "+getId()+
                ", fullname= "+getFullName()+
                ",  Address= "+getAddress()+
                ", priority= "+getPriority()+
                ", maths= " + maths +
                ", chemistry= " + chemistry +
                ", biology= " + biology +
                ", Average= "+average();
    }
}
