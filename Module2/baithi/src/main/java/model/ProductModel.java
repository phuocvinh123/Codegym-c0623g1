package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import service.ECategory;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    private Long id;
    private  String name;
    private String description;
    private double price;
    private ECategory category;
    private int quantity;


}
