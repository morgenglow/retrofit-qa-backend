package ru.geekbrains;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.dto.Category;
import ru.geekbrains.dto.Product;
import ru.geekbrains.service.CategoryService;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.Proxy;

import static org.assertj.core.api.Assertions.assertThat;

public class getProductsPositiveTest {
    static ProductService productService;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @Test
    @DisplayName("Позитивный кейс на запрос продуктов")
    @Step("Тест")
    void getProductsPositiveTest() throws IOException {
        Response<Product> response = productService
                .getProducts()
                .execute();
        assertThat(response.code()).isEqualTo(200);

        //размер массива продуктов превышен? ответ =500
    }

}
