package ch.heigvd.pdl.refactoring;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class Orders {

    private List<Order> orders = new ArrayList<Order>();

    public void addOrder(Order order) {
        orders.add(order);
    }

    public int getOrdersCount() {
        return orders.size();
    }

    public Order getOrder(int i) {
        return orders.get(i);
    }

    public JSONArray toJson() {
        JSONArray array = new JSONArray();
        for (Order order : orders) {
            array.put(order.toJson());
        }
        return array;
    }

}
