package ch.heigvd.pdl.refactoring;

import org.json.JSONObject;

public class Product {
    private String code;
    private final Colors color;
    private final Sizes size;
    private double price;
    private String currency;

    public Product(String code, Colors color, Sizes size, double price, String currency) {
        this.code = code;
        this.color = color;
        this.size = size;
        this.price = price;
        this.currency = currency;
    }

    public Product(String code, Colors color, double price, String currency) {
        this(code, color, Sizes.SIZE_NOT_APPLICABLE, price, currency);
    }

    public String getCode() {
        return code;
    }

    public String getColor() {
        return color.toString();
    }

    public Sizes getSize() {
        return size;
    }
    public String getSizeName() {
        return size.name();
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public JSONObject toJson() {
        JSONObject json = new JSONObject();

        json.put("code", code);
        json.put("color", getColor());
        if (getSize() != Sizes.SIZE_NOT_APPLICABLE) {
            json.put("size", getSizeName());
        }
        json.put("price", price);

        json.put("currency", currency);

        return json;
    }
}