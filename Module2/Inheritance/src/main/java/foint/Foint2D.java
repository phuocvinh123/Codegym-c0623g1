package foint;

public class Foint2D {
    private float x;
    private float y;
    public Foint2D(){
    }
    public Foint2D(float x,float y){
        this.x=x;
        this.y=y;
    }
    public float getX(){
        return x;
    }
    public float getY(){
        return y;
    }
    public void setX(float x){
        this.x=x;
    }
    public void setY(float y){
        this.y=y;
    }
    public float[] getXY(){
        float[] xy=new float[2];
        xy[0]=x;
        xy[1]=y;
        return xy;
    }
    public void setXY() {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Foint2D: " + "x=" + x + ", y=" + y ;
    }
}
