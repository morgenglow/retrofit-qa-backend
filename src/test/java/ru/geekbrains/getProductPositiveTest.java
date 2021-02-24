package ru.geekbrains;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.commonRequests.DeleteReq;
import ru.geekbrains.commonRequests.CreateProduct;
import ru.geekbrains.dto.Product;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

public class getProductPositiveTest {
    static ProductService productService;
    static Integer productId;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        productService = RetrofitUtils.getRetrofit().create(ProductService.class);
    }

    @BeforeEach
    void beforeEach() throws IOException {
        productId = CreateProduct.createProduct();
    }

    @Test
    void getProductPositiveTest() throws IOException {
        Response<Product> response = productService
                .getProduct(productId)
                .execute();
        assertThat(response.code()).isEqualTo(200);
    }

    @AfterEach
    void delete() throws IOException{
        DeleteReq.tearDown(productId);
    }

}
