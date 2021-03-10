package ru.geekbrains;

import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.base.enums.CategoryType;
import ru.geekbrains.dto.Category;
import ru.geekbrains.service.CategoryService;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.geekbrains.base.enums.CategoryType.SOME;

public class getZeroCategoryNegativeTest {
   static CategoryService categoryService;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);
    }

    @Test
    @DisplayName("Негативный кейс на запрос категории")
    @Step("Тест")
    void getCategoryNegativeTest() throws IOException {
        Response<Category> response = categoryService
                .getCategory(CategoryType.ZERO.getId())
                .execute();
        assertThat(response.code()).isEqualTo(404);
    }

}
