package ru.geekbrains;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.dto.Category;
import ru.geekbrains.service.CategoryService;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.geekbrains.base.enums.CategoryType.FOOD;
import static ru.geekbrains.base.enums.CategoryType.SOME;

public class getNonexistingCategoryNegativeTest {
   static CategoryService categoryService;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryService.class);
    }

    @Test
    void getCategoryNegativeTest() throws IOException {
        Response<Category> response = categoryService
                .getCategory(SOME.getId())
                .execute();
        assertThat(response.code()).isEqualTo(404);
    }

}
