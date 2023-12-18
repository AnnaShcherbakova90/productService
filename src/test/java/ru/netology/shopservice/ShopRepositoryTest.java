package ru.netology.shopservice;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.shopservice.Product;

public class ShopRepositoryTest {

    Product book = new Product(1, "book", 123);
    Product laptop = new Product(2, "laptop", 456);
    Product cellphone = new Product(3, "cellphone", 789);
    ShopRepository shopRepository = new ShopRepository();

    @Test
    public void shouldFindById() {
       shopRepository.add(book);

       Product expected = book;
       Product actual = shopRepository.findById(1);

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        shopRepository.add(book);
        shopRepository.add(laptop);

        shopRepository.remove(2);
        Product[] expected = {book};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldTrowNotFoundException() {
        shopRepository.add(book);

        Assertions.assertThrows(NotFoundException.class, () -> {
            shopRepository.remove(2);
        });
    }

    @Test
    public void shouldAddProduct() {
        shopRepository.add(book);

        Product[] expected = {book};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldThrowAlreadyExistsException() {
        shopRepository.add(book);

        Assertions.assertThrows(AlreadyExistsException.class, () -> {
            shopRepository.add(book);
        });
    }

}
