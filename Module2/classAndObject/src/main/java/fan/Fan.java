package fan;

public class Fan {
    private static final int SLOW=1;
    private static final int  MEDIUM=2;
    private static final int FAST=3;
    private int speed;
    private boolean on;
    private String color;
    private double radius;

    public Fan() {
        speed=SLOW;
        on=false;
        color="blue";
        radius=5;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        if(on){
            return "speed: "+speed+", on: "+on+", color: "+color+",radius: "+radius+" - Fan is on";
        }else{
           return  "color: "+color+",radius: "+radius+" - Fan is off";
        }
    }

    public static void main(String[] args) {
        Fan fan1=new Fan();
        fan1.setSpeed(FAST);
        fan1.setOn(true);
        fan1.setColor("red");
        fan1.setRadius(10);
        Fan fan2=new Fan();
        fan2.setSpeed(Fan.MEDIUM);
        System.out.println("fan1:"+fan1.toString());
        System.out.println("fan2:"+fan2.toString());

    }
}
