package ch.heigvd.pdl.refactoring;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products = new ArrayList<>();
    private int id;

    public Order(int id) {
        this.id = id;
    }

    public int getOrderId() {
        return id;
    }

    public int getProductsCount() {
        return products.size();
    }

    public Product getProduct(int j) {
        return products.get(j);
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public JSONObject toJson() {
        JSONObject orderJson = new JSONObject();
        orderJson.put("id", getOrderId());
        JSONArray productsJson = new JSONArray();
        for (Product product: products) {
            productsJson.put(product.toJson());
        }
        orderJson.put("products", productsJson);
        return orderJson;
    }
}
