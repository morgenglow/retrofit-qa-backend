package ru.geekbrains;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.junit.jupiter.api.*;
import ru.geekbrains.base.enums.CategoryType;
import ru.geekbrains.commonRequests.CreateProduct;
import ru.geekbrains.commonRequests.DeleteReq;
import ru.geekbrains.dto.Product;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class putNegativeNonexistingProductTest {
    Integer productId =0;
    static ProductService productService;
    Product productChange;

    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @BeforeEach
    @DisplayName("Негативный кейс на создание продукта")
    @Step("Создание данных продукта")
    void setUp(){
        Faker faker = new Faker();
        productChange = new Product()
                .withCategoryTitle(CategoryType.FOOD.getTitle())
                .withPrice((int) (Math.random() * 1000 + 1))
                .withTitle(faker.food().ingredient());
    }

    @SneakyThrows
    @Test
    @Step("Создание продукта")
    void changeProductTest() {
        retrofit2.Response<Product> response =
                productService.changeProduct(productId,productChange)
                        .execute();
        assertThat(response.isSuccessful()).isFalse();
    }
}
