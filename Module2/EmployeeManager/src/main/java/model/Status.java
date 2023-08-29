package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Status implements IParseModel<Status>{
    private EStatus status;
    @Override
    public Status parse(String line) {
        return null;
    }
}
