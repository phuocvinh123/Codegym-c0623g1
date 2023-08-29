package foint;

public class Foint3D extends Foint2D {
    private float z;
    public Foint3D() {
    }
    public Foint3D(float x, float y) {
        super(x, y);
    }

    public Foint3D(float y) {
        this.z = z;
    }

    public Foint3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public float[] getXYZ(){
        float[] xyz=new float[3];
        xyz[0]= getX();
        xyz[1]= getY();
        xyz[2]=z;
        return xyz;
    }
    public void setXYZ(){
        super.setXY();
        this.z=z;
    }

    @Override
    public String toString() {
        return "Foint3D: " + super.toString()+" z: " + z ;
    }
}
