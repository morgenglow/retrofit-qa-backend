package ru.geekbrains;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.dto.Product;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

public class getProductNonexistingIDTest {
    static ProductService productService;
    static Integer productId = 0;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @Test
    void getProductPositiveTest() throws IOException {
        Response<Product> response = productService
                .getProduct(productId)
                .execute();
        assertThat(response.code()).isEqualTo(404);
    }

}
