package bai4;

public class Person {
    private String name;
    private int YearOld;
    private String job;
    private int IdentityCard;

    public Person() {
    }

    public Person(String name, int yearOld, String job, int identityCard) {
        this.name = name;
       this.YearOld = yearOld;
        this.job = job;
        this.IdentityCard = identityCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearOld() {
        return YearOld;
    }

    public void setYearOld(int yearOld) {
        YearOld = yearOld;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getIdentityCard() {
        return IdentityCard;
    }

    public void setIdentityCard(int identityCard) {
        IdentityCard = identityCard;
    }

    @Override
    public String toString() {
        return "Person: " +
                " name= '" + name + '\'' +
                ", YearOld= " + YearOld +
                ", job= '" + job + '\'' +
                ", IdentityCard= " + IdentityCard ;
    }
}
