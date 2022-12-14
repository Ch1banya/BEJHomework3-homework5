package Homework5;

import com.github.javafaker.Faker;
import Homework5.api.ProductService;
import Homework5.dto.Product;
import Homework5.utils.RetrofitUtils;
import lombok.SneakyThrows;
import okhttp3.ResponseBody;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import retrofit2.Response;

import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


public class ModifyProductTest {

    static ProductService productService;
    Product product = null;
    Faker faker = new Faker();
    int id;
    @BeforeAll
    static void beforeAll() {
        productService = RetrofitUtils.getRetrofit()
                .create(ProductService.class);
    }

    @BeforeEach
    void setUp() {
        product = new Product()
                .withTitle(faker.food().ingredient())
                .withCategoryTitle("Food")
                .withId(1) //Milk
                .withPrice(44);

    }

    @SneakyThrows
    @Test
    void ModifyProductTestOne() {
        Response<Product> response = productService.modifyProduct(product).execute();
        assertThat(response.body().getPrice(), equalTo(44));
        assertThat(response.isSuccessful(), CoreMatchers.is(true));


    }

    @SneakyThrows
    @AfterEach
    void tearDown() {
        Response<ResponseBody> response = productService.deleteProduct(1).execute();
        assertThat(response.isSuccessful(), CoreMatchers.is(true));
    }


}