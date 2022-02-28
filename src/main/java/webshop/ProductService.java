package webshop;

public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saleProduct(long id, int amount) {
        Product result = productRepository.findProductById(id);
        if (result.getStock() >= amount) {
            productRepository.updateProductStock(id, amount);
        } else {
            throw new IllegalArgumentException("Not enough product.");
        }
    }
}
