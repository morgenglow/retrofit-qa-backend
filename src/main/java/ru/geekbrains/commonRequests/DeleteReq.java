package ru.geekbrains.commonRequests;

import okhttp3.ResponseBody;
import ru.geekbrains.service.ProductService;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;


public class DeleteReq {
    static ProductService productService;
    static Integer productId;

    public static void tearDown(Integer productId) throws IOException {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
        retrofit2.Response<ResponseBody> response =
                productService.deleteProduct(productId)
                        .execute();
        assertThat(response.isSuccessful()).isTrue();
    }
}
