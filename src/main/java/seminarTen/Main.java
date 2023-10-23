package seminarTen;

import seminarTen.exceptions.ProductAddException;
import seminarTen.exceptions.ProductServiceDeleteException;
import seminarTen.model.Product;
import seminarTen.model.UnitOfWork;
import seminarTen.model.dao.IProductDAO;
import seminarTen.model.dao.InMemoryProductDao;
import seminarTen.model.repository.IRepository;
import seminarTen.model.repository.ProductRepository;
import seminarTen.model.ProductService;

public class Main {
    public static void main(String[] args) throws ProductAddException, ProductServiceDeleteException {
        IProductDAO productDAO = new InMemoryProductDao();
        IRepository<Product> productRepository = new ProductRepository(productDAO);
        ProductService productService = new ProductService(productRepository);
        UnitOfWork unitOfWork = new UnitOfWork(productService);

        Product productOne = new Product(1, "HP 141w", 17000);
        Product productTwo = new Product(2, "HP 141a", 16000);

        //add two products
        unitOfWork.addProduct(productOne);
        unitOfWork.addProduct(productTwo);

        //print repository size
        System.out.println(productRepository.getAll().size());

        //revert all operations
        unitOfWork.revertAllOperations();

        //commit
        unitOfWork.commit();

        //print repository size
        System.out.println(productRepository.getAll().size());

        //add product again
        unitOfWork.addProduct(productOne);

        //commit
        unitOfWork.commit();

        //print repository size
        System.out.println(productRepository.getAll().size());
    }
}
