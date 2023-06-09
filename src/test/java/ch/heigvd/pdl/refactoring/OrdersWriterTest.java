package ch.heigvd.pdl.refactoring;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class OrdersWriterTest {
    Orders orders = new Orders();
    Order order111 = new Order(111);

    @BeforeEach
    public void SetupOneOrder() {
        orders.addOrder(order111);
    }

    @Test
    public void NoOrder() {
        assertEquals("{\"orders\":[]}", new OrdersWriter(new Orders()).getContents());
    }

    @Test
    public void OneOrder() {
        String order111 = "{\"id\":111,\"products\":[]}";
        assertEquals("{\"orders\":[" + order111 + "]}", new OrdersWriter(orders).getContents());
    }

    @Test
    public void TwoOrders() {
        orders.addOrder(new Order(222));
        String order111Json = JsonOrder111WithProduct("");
        String order222Json = "{\"id\":222,\"products\":[]}";
        assertEquals("{\"orders\":[" + order111Json + "," + order222Json + "]}", new OrdersWriter(orders).getContents());
    }

    @Test
    public void OneOrderWithOneProduct() {
        order111.addProduct(new Product("Shirt", Colors.BLUE, Sizes.M, 2.99, "TWD"));
        String order111Json = JsonOrder111WithProduct("{\"code\":\"Shirt\",\"color\":\"blue\",\"size\":\"M\",\"price\":2.99,\"currency\":\"TWD\"}");
        assertEquals("{\"orders\":[" + order111Json + "]}", new OrdersWriter(orders).getContents());
    }

    @Test
    public void OneOrderWithOneProductNoSize() {
        order111.addProduct(new Product("Pot", Colors.RED, 16.50, "SGD"));
        String order111Json = JsonOrder111WithProduct("{\"code\":\"Pot\",\"color\":\"red\",\"price\":16.5,\"currency\":\"SGD\"}");
        assertEquals("{\"orders\":[" + order111Json + "]}", new OrdersWriter(orders).getContents());
    }

    @Test
    void CheckColors() {
        Product product = new Product("Pot", Colors.RED, Sizes.SIZE_NOT_APPLICABLE, 16.50, "SGD");
        String color = "red";
        assertEquals(color, product.getColor());
    }

    @Test
    void CheckSizes() {
        Product product = new Product("Pot", Colors.RED, Sizes.M, 16.50, "SGD");
        String color = "M";
        assertEquals(color, product.getSizeName());
    }

    private String JsonOrder111WithProduct(String productJson) {
        return "{\"id\":111,\"products\":[" + productJson + "]}";
    }

}
