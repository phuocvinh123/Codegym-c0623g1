package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product implements IParseModel<Product>{
    private long id;
    private String name;
    private String description;
    private double price;
    private ECategory category;




    public Product parse(String line) {
        String[] items = line.split(",");
        Product p = new Product(Long.parseLong(items[0]), items[1], items[2], Double.parseDouble(items[3]), ECategory.valueOf(items[4]));
        return p;
    }
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", this.id, this.name, this.description,this.price,this.category);
    }
}
