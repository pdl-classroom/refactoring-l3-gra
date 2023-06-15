package ch.heigvd.pdl.refactoring;

public class Product {



    private String code;

    public enum Colors {
        blue,
        red,
        yellow,
        no_color
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
        return color.name();
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

}