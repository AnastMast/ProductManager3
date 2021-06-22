package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;





class ProductManagerTest {
     private ProductRepository repository = new ProductRepository();
     private Product prod1 = new Book(1,"Война и мир",200,"Толстой");
     private Product prod2 = new Book(2,"Мастер и Маргарита",400,"Булгаков");
    private Product prod3 = new Book(3,"Анна Каренина",800,"Толстой");
     private Product prod4 = new Smartphone(4,"S8",300,"Samsung");

  @Test
    void SearchBy() {
        repository.save(prod1);
        repository.save(prod2);
        repository.save(prod3);
        repository.save(prod4);
        ProductManager manager = new ProductManager(repository);
        Product[] actual = manager.searchBy("Булгаков");
        Product[] expected = new Product[]{prod2};

        assertArrayEquals(actual, expected);
    }

    @Test
    void SearchBy2() {
        repository.save(prod1);
        repository.save(prod2);
        repository.save(prod3);
        repository.save(prod4);
        ProductManager manager = new ProductManager(repository);
        Product[] actual = manager.searchBy("Толстой");
        Product[] expected = new Product[]{prod1,prod3};

        assertArrayEquals(actual, expected);
    }
    @Test
    void SearchBy4() {
        repository.save(prod1);
        repository.save(prod2);
        repository.save(prod3);
        repository.save(prod4);
        ProductManager manager = new ProductManager(repository);
        Product[] actual = manager.searchBy("Nothing");
        Product[] expected = new Product[]{};

        assertArrayEquals(actual, expected);
    }

}