package Service;

import Model.ProductModel;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductService {
    private String fileProduct = "./data/product.json";
    private Gson gson = new Gson();

    public List<ProductModel> read() {
        List<ProductModel> productList = new ArrayList<>();
        try (FileReader reader = new FileReader(fileProduct)) {
            JsonElement jsonElement = JsonParser.parseReader(reader);
            JsonArray jsonArray = jsonElement.getAsJsonArray();
            for (JsonElement element : jsonArray) {
                ProductModel product = gson.fromJson(element, ProductModel.class);
                productList.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return productList;
    }

    public void write(List<ProductModel> products) {
        try (FileWriter writer = new FileWriter(fileProduct)) {
            gson.toJson(products, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteProductById(int productId) {
        List<ProductModel> products = read();
        Iterator<ProductModel> iterator = products.iterator();
        while (iterator.hasNext()) {
            ProductModel product = iterator.next();
            if (product.getId() == productId) {
                iterator.remove();
                System.out.println("Product with ID " + productId + " deleted.");
            }
        }
        write(products);
    }
    public ProductModel findProductById(int productId) {
        List<ProductModel> products = read();
        for (ProductModel product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }

        return null; // Trả về null nếu không tìm thấy sản phẩm
    }
    public void updateProductById(int productId, ProductModel updatedProduct) {
        List<ProductModel> products = read();
        for (ProductModel product : products) {
            if (product.getId() == productId) {
                product.setName(updatedProduct.getName());
                product.setDescription(updatedProduct.getDescription());
                product.setPrice(updatedProduct.getPrice());
                System.out.println("Product with ID " + productId + " updated.");
                break;
            }
        }

        write(products);
    }

}

