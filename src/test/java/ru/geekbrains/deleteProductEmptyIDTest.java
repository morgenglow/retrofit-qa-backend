package ru.geekbrains;

import okhttp3.ResponseBody;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.dto.Product;
import ru.geekbrains.service.ProductErrService;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

public class deleteProductEmptyIDTest {
    static ProductErrService productErrService;
    static String productId = " ";

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        productErrService = RetrofitUtils.getRetrofit().create(ProductErrService.class);
    }

    @Test
    void tearDown() {
        try {
            retrofit2.Response<ResponseBody> response =
                    productErrService.deleteProduct(productId)
                            .execute();
            assertThat(response.code()).isEqualTo(400);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
