package ch.heigvd.pdl.refactoring;

public class Product {

    public static final int SIZE_NOT_APPLICABLE = -1;

    private String code;

    public enum Colors {
        blue,
        red,
        yellow,
        no_color
    }

    private final Colors color;
    private int size;

    private double price;
    private String currency;

    public Product(String code, Colors color, int size, double price, String currency) {
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

    public int getSize() {
        return size;
    }
    public String getSizeName() {
        final String[] sizes = {"XS", "S","M","L","XL","XXL"};

        if (size < 1 || size - 1 > sizes.length)
            return "Invalid Size";
        return sizes[size - 1];
    }

    public double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

}