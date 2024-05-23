package api.test;

import api.endpoints.StoreEndpoints;
import api.payload.Store;
import api.utilities.DataProviders;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;



public class DDTStoreTest {

    Store storepayload;


    @Test(priority=1, dataProvider="Order", dataProviderClass= DataProviders.class)
    public void testCreateOder(String orderid, String Petid, String quantity, String Shipdate) // in order as it is in xlsx file
    {
        storepayload = new Store();

        storepayload.setId(Integer.parseInt(orderid));
        storepayload.setPetId(Integer.parseInt(Petid));
        storepayload.setQuantity(Integer.parseInt(quantity));
        storepayload.setShipDate(String.valueOf(Shipdate));

        Response response = StoreEndpoints.createOrder(storepayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

    }

    @Test(priority=2, dataProvider = "OrderId", dataProviderClass= DataProviders.class)
    public void testDeleteOrder(String orderid)
    {
        Response response = StoreEndpoints.deleteOrder(Integer.parseInt(orderid));
        Assert.assertEquals(response.getStatusCode(),200);


    }
}
