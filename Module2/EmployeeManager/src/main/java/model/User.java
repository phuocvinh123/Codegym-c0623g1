package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.DateUtils;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class User implements IParseModel<User>{
    private long id;
    private String name;
    private String password;
    private int age;
    private LocalDate dob;
    private Gender gender;


//    public User(long id, String name, String password, int i, LocalDate localDate, Gender gender) {
//        this.id = id;
//        this.name = name;
//        this.password = password;
//    }

    public static void main(String[] args) {
    }

    @Override
    public User parse(String line) {
        String[] items = line.split(",");
        User u = new User(Long.parseLong(items[0]), items[1], items[2],Integer.parseInt(items[3]),
                DateUtils.parseDate(items[4]), Gender.valueOf(items[5]));
        return u;
    }

    @Override
    public String toString() {
        //3,Quang Dang2,123123,18,18-07-1992,MALE
        return String.format("%s,%s,%s,%s,%s,%s", this.id, this.name, this.password, this.age,
                DateUtils.formatDate(this.dob), this.gender);
    }
}
