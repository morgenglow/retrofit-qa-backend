package ru.geekbrains.service;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import ru.geekbrains.dto.Category;
import ru.geekbrains.dto.CategoryErr;

public interface CategoryErrService {
    @GET("categories/{id}")
    Call<CategoryErr> getCategory(@Path("id") String id);
}
