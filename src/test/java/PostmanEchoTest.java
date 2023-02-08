import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    public void shouldReturnDemoAccount() {
// Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("04.01.1984") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .body("data", equalTo("04.01.1984"));


    }

    @Test
    public void shouldReturnDemoAccount1() {
        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("some data")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("some data"));

    }

    @Test
    void shouldReturnDemoAccounts1() {
        given()
                .baseUri("https://postman-echo.com")
                .body("id:2")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("id:2"));
    }

    @Test
    void shouldReturnDemoAccounts3() {
        given()
                .baseUri("https://postman-echo.com")
                .body("currency:RUB")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("currency:RUB"));
    }

}
