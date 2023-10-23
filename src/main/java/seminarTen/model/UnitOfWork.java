package seminarTen.model;

import seminarTen.exceptions.ProductAddException;
import seminarTen.exceptions.ProductServiceDeleteException;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс для реализации паттерна UnitOfWork
 * В случае большого количества повторяющихся оперций в небольшой промежуток времени
 * помогает снизить нагрузку на репозиторий, накапливая изменения и применяя их по команде.
 */
public class UnitOfWork {
    private final ProductService productService;

    public UnitOfWork(ProductService productService) {
        this.productService = productService;
    }

    private final List<Product> addedProducts = new ArrayList<>();
    private final List<Product> deletedProducts = new ArrayList<>();

    public void addProduct(Product product) {
        addedProducts.add(product);
    }

    public void deleteProduct(Product product) {
        deletedProducts.add(product);
    }

    public void commit() throws ProductAddException, ProductServiceDeleteException {
        for (Product product : addedProducts) {
            productService.addProductWithLogic(product);
        }
        for (Product product : deletedProducts) {
            productService.deleteProductWithLogic(product.getId());
        }
        addedProducts.clear();
        deletedProducts.clear();
    }

    public void revertAllOperations() {
        addedProducts.clear();
        deletedProducts.clear();
    }

    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

}
