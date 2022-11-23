package com.example.extendinjpa.product;

import com.example.extendinjpa.product.entity.Album;
import com.example.extendinjpa.product.entity.Book;
import com.example.extendinjpa.product.entity.Product;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.TestConstructor;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@RequiredArgsConstructor
@TestConstructor(autowireMode = TestConstructor.AutowireMode.ALL)
public class ProductServiceTest {
    private final ProductRepository productRepository;
    private final ProductService productService;

    @Test
    @Rollback(value = false)
    public void getProduct() {
        Product product = new Product("product1", 10000);
        Product savedProduct = productService.addProduct(product);

        Assertions.assertThat(product).isEqualTo(savedProduct);
    }

    @Test
    @Rollback(value = false)
    public void getBook() {
        Book book = new Book("book1", 10000, "isbs1");
        Product savedBook = productService.addProduct(book);

        Album album = new Album("album1", 10000, "sting");
        Product savedAlbum = productService.addProduct(album);

        Product getBook = productService.getProduct(savedBook.getId());
        Product getAlbum = productService.getProduct(savedAlbum.getId());

        Assertions.assertThat(getBook instanceof Product).isTrue();
        Assertions.assertThat(getBook instanceof Book).isTrue();
        Assertions.assertThat(getBook instanceof Album).isFalse();

        Assertions.assertThat(getAlbum instanceof Product).isTrue();
        Assertions.assertThat(getAlbum instanceof Album).isTrue();
        Assertions.assertThat(getAlbum instanceof Book).isFalse();
    }

    @Test
    public void addProduct() {
    }
}