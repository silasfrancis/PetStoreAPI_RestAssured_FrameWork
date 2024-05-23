package api.test;

import api.endpoints.PetEndpoints;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class PetTest_withExternalJSON {

    @Test(priority=1)
    public void testCreatePetUsingExternalJson(ITestContext context)throws FileNotFoundException
    {
        File f = new File(".\\testData\\Petdata.json");
        FileReader fr = new FileReader(f);
        JSONTokener jt = new JSONTokener(fr);
        JSONObject data = new JSONObject(jt);

        Response response = PetEndpoints.createPet(data);
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(), 200);


        int petid = (int) Integer.parseInt(response.jsonPath().get("id").toString());
        context.setAttribute("petid", petid);


    }

    @Test(priority=2)
    public void testDeletePet(ITestContext context)

    {
        int pet_id = (int) context.getAttribute("petid");

        Response res = PetEndpoints.deletePet(pet_id);
        Assert.assertEquals(res.getStatusCode(), 200);


    }


}
