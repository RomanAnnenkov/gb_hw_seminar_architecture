package seminarTen.model.dao;

import seminarTen.model.Product;

import java.util.ArrayList;
import java.util.List;
/**
 * Реализация интерфейса доступа к продукту, в качестве системы хранения выбран список в ОЗУ.
  */
public class InMemoryProductDao implements IProductDAO {

    List<Product> products = new ArrayList<>();

    @Override
    public void add(Product product) {
        products.add(product);
    }

    @Override
    public Product find(int productId) {
        for (Product product : products) {
            if (product.getId() == productId) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public void remove(int productId) {
        products.removeIf(product -> product.getId() == productId);
    }
}
