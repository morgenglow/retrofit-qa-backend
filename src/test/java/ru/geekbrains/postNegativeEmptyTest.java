package ru.geekbrains;

import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.geekbrains.base.enums.CategoryType;
import ru.geekbrains.dto.Product;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.util.RetrofitUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class postNegativeEmptyTest {
    Integer productId;
    Faker faker = new Faker();
    static ProductService productService;
    Product product;

    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @BeforeEach
    void setUp() {
        product = new Product()
                .withCategoryTitle(" ")
                .withPrice(0)
                .withTitle(" ");
    }

    @SneakyThrows
    @Test
    void createNewProductNegativeTest() {
        retrofit2.Response<Product> response =
                productService.createProduct(product)
                        .execute();
        assertThat(response.code()).isEqualTo(201);

//        падает со статусом 500
    }
}
