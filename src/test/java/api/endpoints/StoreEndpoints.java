package api.endpoints;

import api.payload.Store;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreEndpoints {

    public static Response createOrder(Store payload)
    {
        Response response= given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)

                .when()
                .post(Routes.post_order_url);

        return response;
    }

        public static  Response getOrder(int orderid)
        {

            Response response=given()
                    .pathParam("orderId", orderid)

                    .when()
                    .get(Routes.get_order_url);

            return response;
        }

        public static Response deleteOrder(int orderid)
        {

            Response response = given()
                    .pathParam("orderId", orderid)

                    .when()
                    .delete(Routes.delete_order_url);

            return response;
        }



}
