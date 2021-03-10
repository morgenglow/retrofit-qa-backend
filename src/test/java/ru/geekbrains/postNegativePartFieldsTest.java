package ru.geekbrains;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.geekbrains.base.enums.CategoryType;
import ru.geekbrains.dto.Product;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.util.RetrofitUtils;

import static org.assertj.core.api.Assertions.assertThat;

public class postNegativePartFieldsTest {
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
                .withCategoryTitle(CategoryType.FOOD.getTitle())
                .withTitle(faker.food().ingredient());
    }

    @SneakyThrows
    @Test
    @Step("Создание продукта")
    void createNewProductNegativeTest() {
        retrofit2.Response<Product> response =
                productService.createProduct(product)
                        .execute();
        assertThat(response.code()).isEqualTo(201);
    }
}
