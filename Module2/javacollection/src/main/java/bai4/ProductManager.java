package bai4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductManager {
    List<Product>products;
    public ProductManager(){this.products=new ArrayList<>();}
    public void addProduct(Product product){
        this.products.add(product);
    }
    public void show(){this.products.forEach(pro -> System.out.println(pro.toString()));}
    public List<Product> search(String name){
        return this.products.stream().filter(product -> product.getNameProduct().contains(name)).collect(Collectors.toList());
    }
    public boolean delete(String name){
        Product pro=this.products.stream().filter(product -> product.getNameProduct().equals(name)).findFirst().orElse(null);
        if(pro==null){
            return false;
        }
        this.products.remove(pro);
        return true;
    }
}
