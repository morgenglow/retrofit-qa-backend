package ru.geekbrains;

import com.github.javafaker.Faker;
import io.qameta.allure.Description;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.junit.jupiter.api.*;
import ru.geekbrains.base.enums.CategoryType;
import ru.geekbrains.dto.Product;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

public class deleteNegativeTest {
    Integer productId = 2000000;
    Faker faker = new Faker();
    static ProductService productService;

    @SneakyThrows
    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @Test
    @DisplayName("Негативный кейс на удаление продукта")
    @Description("Удаление несуществующего продукта")
    void tearDown() {
        try {
            retrofit2.Response<ResponseBody> response =
                    productService.deleteProduct(productId)
                            .execute();
            assertThat(response.code()).isEqualTo(500);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
