package ru.geekbrains.service;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;
import ru.geekbrains.dto.Category;
import ru.geekbrains.dto.Product;

public interface ProductService {
    @POST("products")
    Call<Product> createProduct(@Body Product createProductRequest);

    @DELETE("products/{id}")
    Call<ResponseBody> deleteProduct(@Path("id") Integer id);

    @GET("products")
    Call<Product> getProducts();

    @GET("products/{id}")
    Call<Product> getProduct(@Path("id") Integer id);

    @PUT ("products/{id}")
    Call<Product> changeProduct(@Path("id") Integer id, @Body Product changeProductRequest);
}
