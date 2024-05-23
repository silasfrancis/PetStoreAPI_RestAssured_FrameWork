package api.test;

import api.endpoints.StoreEndpoints;
import com.github.javafaker.Faker;
import api.payload.Store;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreTest {

    Faker faker;
    Store storepayload;
    public Logger logger;

    @BeforeClass
    public void setupOrder()
    {
        faker = new Faker();
        storepayload = new Store();

        storepayload.setId(faker.idNumber().hashCode());
        storepayload.setPetId(faker.number().numberBetween(1,9));
        storepayload.setQuantity(faker.number().numberBetween(1,9));
        storepayload.setShipDate(String.valueOf(faker.date().hashCode()));

        logger = LogManager.getLogger(this.getClass());
    }

    @Test(priority=1)
    public void testCreateOrder()
    {
        logger.info("************** Creating Order **************");

        Response response = StoreEndpoints.createOrder(storepayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("****************** Order Placed *******************");

    }

    @Test(priority=2)
    public void testGetOrder()
    {
        logger.info("************** Fetching Order Info **************");
        Response response = StoreEndpoints.getOrder(this.storepayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("********* Order Info Displayed***********");

    }

    @Test(priority=3)
    public void testDeleteOrder()
    {
        logger.info("************** Deleting Order **************");
        Response response = StoreEndpoints.deleteOrder(this.storepayload.getId());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("********* Order Deleted***********");

    }


}
