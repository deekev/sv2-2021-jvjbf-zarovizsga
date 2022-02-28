package webshop;

public class Product {

    private Long id;
    private String productName;
    private int price;
    private int stock;

    public Product(String productName, int price, int stock) {
        this.productName = productName;
        this.price = price;
        this.stock = stock;
    }

    public Product(Long id, String productName, int price, int stock) {
        this(productName, price, stock);
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }
}
