package ru.geekbrains;

import com.github.javafaker.Faker;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.*;
import ru.geekbrains.base.enums.CategoryType;
import ru.geekbrains.commonRequests.CreateProduct;
import ru.geekbrains.commonRequests.DeleteReq;
import ru.geekbrains.dto.Product;
import ru.geekbrains.java4.lesson6.db.dao.ProductsMapper;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.util.DbUtils;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class putPositiveTest {
    Integer productId;
    static ProductService productService;
    Product productChange;
    static ProductsMapper productsMapper;
    Product product;

    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        productsMapper = DbUtils.getProductsMapper();
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @BeforeEach
    @DisplayName("Позитивный кейс на изменение продукта")
    @Step("Создание данных продукта")
    void setUp() throws IOException {
        product = CreateProduct.createProduct();
        productId = product.getId();
        Faker faker = new Faker();
        productChange = new Product()
                .withCategoryTitle(CategoryType.FOOD.getTitle())
                .withPrice((int) (Math.random() * 1000))
                .withTitle(faker.food().ingredient());
    }

    @SneakyThrows
    @Test
    @Step("Изменение данных продукта")
    void changeProductTest() {
        retrofit2.Response<Product> response =
                productService.changeProduct(productId,productChange)
                        .execute();
        assertThat(response.isSuccessful()).isTrue();
        assertThat(response.body().getTitle()).isEqualTo(productChange.getTitle());
    }

    @AfterEach
    @Step("Удаление продукта")
    void delete(){
        DbUtils.getProductsMapper().deleteByPrimaryKey(Long.valueOf(productId));
    }
}
