package Homework5;

import Homework5.api.CategoryService;
import Homework5.api.ProductService;
import Homework5.dto.GetCategoryResponse;
import Homework5.dto.Product;
import Homework5.utils.RetrofitUtils;
import com.github.javafaker.Faker;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import retrofit2.Response;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class GetProductByIdTest {

    static ProductService productService;
    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }
    @SneakyThrows
    @Test
    void getProductByIdTestOne() {
        Response<Product> response = productService.getProductById(1).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(1));
        assertThat(response.body().getTitle(), equalTo("Milk"));
        assertThat(response.body().getPrice(), equalTo(95));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));



    }

    @SneakyThrows
    @Test
    void getProductByIdTestTwo() {
        Response<Product> response = productService.getProductById(2).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(2));
        assertThat(response.body().getTitle(), equalTo("Bread"));
        assertThat(response.body().getPrice(), equalTo(25));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));



    }

    @SneakyThrows
    @Test
    void getProductByIdTestThree() {
        Response<Product> response = productService.getProductById(3).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(3));
        assertThat(response.body().getTitle(), equalTo("Cheese"));
        assertThat(response.body().getPrice(), equalTo(360));
        assertThat(response.body().getCategoryTitle(), equalTo("Food"));

    }

    @SneakyThrows
    @Test
    void getProductByIdTestThreeFour() {
        Response<Product> response = productService.getProductById(4).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(4));
        assertThat(response.body().getTitle(), equalTo("Samsung Watch X1000"));
        assertThat(response.body().getPrice(), equalTo(20000));
        assertThat(response.body().getCategoryTitle(), equalTo("Electronic"));


    }

    @SneakyThrows
    @Test
    void getProductByIdTestThreeFive() {
        Response<Product> response = productService.getProductById(5).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
        assertThat(response.body().getId(), equalTo(5));
        assertThat(response.body().getTitle(), equalTo("LG TV 1"));
        assertThat(response.body().getPrice(), equalTo(50000));
        assertThat(response.body().getCategoryTitle(), equalTo("Electronic"));


    }

    @SneakyThrows
    @Test
    void tearDown() {
        Response<ResponseBody> response = productService.deleteProduct(5).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }
}