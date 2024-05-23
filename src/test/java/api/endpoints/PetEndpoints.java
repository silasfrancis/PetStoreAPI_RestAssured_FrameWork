package api.endpoints;

import static io.restassured.RestAssured.given;

import api.test.PetTests;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

public class PetEndpoints {

    public static Response createPet(JSONObject data)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(data.toString())


                .when()
                .post(Routes.post_pet_url);

        return response;
    }

    public static Response readPet(long id)
    {
        Response response = given()
                .pathParam("petid", id)

                .when()
                .get(Routes.get_pet_url);

        return response;

    }

    public static Response updatePet( JSONObject data)
    {
        Response response = given()
                .contentType(ContentType.JSON)
                .contentType(ContentType.JSON)
                .body(data.toString())


                .when()
                .put(Routes.update_pet_url);

        return response;
    }

    public static Response deletePet(long id)
    {
        Response response = given()
                .pathParam("petid", id)

                .when()
                .delete(Routes.delete_pet_url);

        return response;

    }

}
