package bai1;

public class Engineer extends Cadres{
    protected String TrainingIndustry;

    public Engineer(String trainingIndustry) {
        TrainingIndustry = trainingIndustry;
    }

    public Engineer(String name, int age, String gender, String address, String trainingIndustry) {
        super(name, age, gender, address);
        TrainingIndustry = trainingIndustry;
    }

    @Override
    public String toString() {
        return "Engineer: " +
                "TrainingIndustry='" + TrainingIndustry +
                ", name= " + name +
                ", age= " + age +
                ", gender= " + gender +
                ", address= " + address  ;
    }
}
