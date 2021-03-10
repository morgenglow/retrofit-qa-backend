package ru.geekbrains;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import ru.geekbrains.dto.CategoryErr;
import ru.geekbrains.service.CategoryErrService;
import ru.geekbrains.util.RetrofitUtils;

import java.io.IOException;
import java.net.MalformedURLException;

import static org.assertj.core.api.Assertions.assertThat;

public class getEmptyCategoryNegativeTest {
   static CategoryErrService categoryService;

    @BeforeAll
    static void beforeAll() throws MalformedURLException {
        categoryService = RetrofitUtils.getRetrofit().create(CategoryErrService.class);
    }

    @Test
    @DisplayName("Негативный кейс на запрос категории")
    @Step("Тест")
    @Description("Запрос несуществующей категории")
    void getCategoryNegativeTest() throws IOException {
        Response<CategoryErr> response = categoryService
                .getCategory(" ")
                .execute();
        assertThat(response.code()).isEqualTo(400);
        //500-я ошибка, должна быть 400
    }

}
