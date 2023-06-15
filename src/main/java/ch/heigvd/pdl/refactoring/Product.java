package ch.heigvd.pdl.refactoring;

public class Product {

    public static final int SIZE_NOT_APPLICABLE = -1;

    private String code;
    private int color;
    private int size;
    private double price;
    private String currency;

    public Product(String code, int color, int size, double price, String currency) {
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
        switch (color) {
            case 1:
                return "blue";
            case 2:
                return "red";
            case 3:
                return "yellow";
            default:
                return "no color";
        }
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