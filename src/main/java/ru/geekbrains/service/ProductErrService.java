package ru.geekbrains.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import ru.geekbrains.dto.Product;

public interface ProductErrService {
    @GET("products/{id}")
    Call<Product> getProduct(@Path("id") String id);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") String id);
}
