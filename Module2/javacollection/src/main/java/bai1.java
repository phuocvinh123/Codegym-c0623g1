import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class bai1 {
    public static void main(String[] args) {
        Map<String,Integer>map=new HashMap<>();
        map.put("quang",21);
        map.put("Huy",25);
        map.put("Thắng",22);
        map.put("Đạt",26);
        System.out.println(map+"\n");
        Map <String,Integer> tremap=new TreeMap<>(map);
        System.out.println(tremap);
        Map<String,Integer>linkedHashMap = new LinkedHashMap<>(16, 0.75f, true);
        linkedHashMap.put("Smith", 30);
        linkedHashMap.put("Anderson", 31);
        linkedHashMap.put("Lewis", 29);
        linkedHashMap.put("Cook", 29);
        System.out.println("\nThe age for " + "Lewis is " + linkedHashMap.get("Lewis"));
    }
}
