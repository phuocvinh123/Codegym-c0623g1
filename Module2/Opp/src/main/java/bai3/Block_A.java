package bai3;

public class Block_A extends Student{
    private int maths;
    private int physical;
    private int chemistry;

    public Block_A(int maths, int physical, int chemistry) {
        this.maths = maths;
        this.physical = physical;
        this.chemistry = chemistry;
    }

    public Block_A(String id, String fullName, String address, String priority, int maths, int physical, int chemistry) {
        super(id, fullName, address, priority);
        this.maths = maths;
        this.physical = physical;
        this.chemistry = chemistry;
    }

    public int getMaths() {
        return maths;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public int getPhysical() {
        return physical;
    }

    public void setPhysical(int physical) {
        this.physical = physical;
    }

    public int getChemistry() {
        return chemistry;
    }

    public void setChemistry(int chemistry) {
        this.chemistry = chemistry;
    }

    @Override
    public double average() {
        return (double) (this.maths + this.physical + this.chemistry) /3;
    }

    @Override
    public String toString() {
        return "block_A: " +
                " id= "+getId()+
                ", fullname= "+getFullName()+
                ",  Address= "+getAddress()+
                ", priority= "+getPriority()+
                ", maths= " + maths +
                ", physical= " + physical +
                ", chemistry= " + chemistry +
                ", Average= "+average();
    }
}
