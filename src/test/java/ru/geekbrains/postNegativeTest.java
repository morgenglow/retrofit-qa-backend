package ru.geekbrains;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.*;
import ru.geekbrains.base.enums.CategoryType;
import ru.geekbrains.dto.Product;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;
import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;

public class postNegativeTest {
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
    @DisplayName("Негативный кейс на создание продукта")
    @Step("Создание данных продукта")
    void setUp() {
        product = new Product()
                .withId(557)
                .withCategoryTitle(CategoryType.FOOD.getTitle())
                .withPrice((int) (Math.random() * 1000 + 1))
                .withTitle(faker.food().ingredient());
    }

    @SneakyThrows
    @Test
    @Step("Создание продукта")
    void createNewProductNegativeTest() {
        retrofit2.Response<Product> response =
                productService.createProduct(product)
                        .execute();
        assertThat(response.code()).isEqualTo(400);
    }
}
