package ru.geekbrains;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.dto.Product;
import ru.geekbrains.service.ProductErrService;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

public class getProductEmptyIDTest {
    static ProductErrService productErrService;
    static String productId = " ";

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        productErrService = RetrofitUtils.getRetrofit().create(ProductErrService.class);
    }

    @Test
    @DisplayName("Негативный кейс на запрос продукта")
    @Step("Тест")
    @Description("Запрос несуществующего продукта с пустым ID")
    void getProductNegativeTest() throws IOException {
        Response<Product> response = productErrService
                .getProduct(productId)
                .execute();
        assertThat(response.code()).isEqualTo(404);
//        падает в ошибку 500
    }
}
