package api.test;

import api.endpoints.PetEndpoints;
import api.payload.PetJSONObjectData;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

public class PetTests {

    Faker faker = new Faker();
    public Logger logger = LogManager.getLogger(this.getClass());

    @Test(priority=1)
    public void testPet(ITestContext context)

    {
        logger.info("********* Creating Pet Info***********");
        Response response = PetEndpoints.createPet(PetJSONObjectData.data);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);


        logger.info("********* Pet Info Created ***********");

        long petid = Long.parseLong(response.jsonPath().get("id").toString());
        context.setAttribute("petid", petid);



    }


    @Test(priority=2)
    public void testGetPet(ITestContext context)

    {
        long pet_id = (long) context.getAttribute("petid");

        logger.info("********* Fetching Pet Info***********");

        Response res = PetEndpoints.readPet(pet_id);
        res.then().log().all();
        Assert.assertEquals(res.getStatusCode(), 200);

        logger.info("********* Pet Info Displayed ***********");
        long petid = Long.parseLong(res.jsonPath().get("id").toString());
        context.setAttribute("pet_id", petid);

    }

    @Test(priority=3)
    public void testUpdatePet(ITestContext context)

    {

        logger.info("********* Updating Pet Info***********");


        PetJSONObjectData.data.put("status", "available");

        Response response = PetEndpoints.updatePet(PetJSONObjectData.data);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("********* Pet Info Updated ***********");

    }

    @Test(priority=4)
    public void testDeletePet(ITestContext context)

    {
        long pet_id = (long) context.getAttribute("pet_id");

        logger.info("********* Deleting Pet Info***********");

        Response res = PetEndpoints.deletePet(pet_id);
        Assert.assertEquals(res.getStatusCode(), 200);

        logger.info("********* Pet Info Deleted ***********");

    }













}
