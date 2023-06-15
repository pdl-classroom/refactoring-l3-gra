package ch.heigvd.pdl.refactoring;

import org.json.JSONObject;

public class Product {



    private String code;

    public enum Colors {
        BLUE,
        RED,
        YELLOW,
        NO_COLOR;
        @Override
        public String toString() {
            return this.name().toLowerCase();
        }
    }

    private final Colors color;


    public enum Sizes {
        XS,
        S,
        M,
        L,
        XL,
        XXL,
        SIZE_NOT_APPLICABLE
    }

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

        json.append("code", code);
        json.append("color", getColor());
        if (getSize() != SIZE_NOT_APPLICABLE) {
            json.append("size", getSizeName());
        }
        json.append("price", price);

        json.append("currency", currency);

        return json;
    }
}