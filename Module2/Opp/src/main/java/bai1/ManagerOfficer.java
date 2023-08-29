package bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManagerOfficer {
    private List<Cadres> cadres;
    public ManagerOfficer() {
        this.cadres = new ArrayList<>();
    }

    public void addOfficer(Cadres cadres) {
        this.cadres.add(cadres);
    }

    public List<Cadres> searchOfficerByName(String name) {
        return this.cadres.stream().filter(o -> o.getName().contains(name)).collect(Collectors.toList());
    }

    public void showListInforOfficer() {
        this.cadres.forEach(o -> System.out.println(o.toString()));
    }
}
