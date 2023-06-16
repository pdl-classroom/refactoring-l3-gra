package ch.heigvd.pdl.refactoring;

import org.json.JSONObject;

public class OrdersWriter {

    private Orders orders;

    public OrdersWriter(Orders orders) {
        this.orders = orders;
    }

    public String getContents() {
        JSONObject json = new JSONObject();

        json.put("orders", orders.toJson());

        return json.toString();
    }
}