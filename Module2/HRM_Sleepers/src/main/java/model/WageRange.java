package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import utils.DateUtils;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WageRange implements IParseModel<WageRange> {
    private long id;
    private long idUser;
    private LocalDate time;
    private double wage;
    private LocalDate month;

    @Override
    public WageRange parse(String line) {
        String[] items = line.split(",");
        WageRange wageRange= new WageRange(Long.parseLong(items[0]),Long.parseLong(items[1]), DateUtils.parseDate(items[2]),Double.parseDouble(items[3]), DateUtils.parseDate(items[4]) );
        return wageRange;
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s",this.id,this.idUser,DateUtils.formatDate(this.time),this.wage,this.month);
    }

}
