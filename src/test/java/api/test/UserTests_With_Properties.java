package api.test;

import api.endpoints.UserEndPoints_withProperties;
import api.payload.User;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class UserTests_With_Properties {

    Faker faker;
    User userPayload;
    public Logger logger;

    @BeforeClass
    public void  setupData()
    {
        faker = new Faker();
        userPayload = new User();

        userPayload.setId(faker.idNumber().hashCode());
        userPayload.setUsername(faker.name().username());
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());
        userPayload.setPassword(faker.internet().password());
        userPayload.setPhone(faker.phoneNumber().cellPhone());

        logger = LogManager.getLogger(this.getClass());

    }

    @Test(priority=1)
    public void testPostUser()
    {
        logger.info("********* Creating User ***********");
        Response response = UserEndPoints_withProperties.createUser(userPayload);
        response.then().log().all();

        Assert.assertEquals(response.getStatusCode(), 200);

        logger.info("********* User Created ***********");

    }

    @Test(priority=2)
    public void testGetUserbyName()
    {
        logger.info("********* Reading User Info ***********");
        Response response = UserEndPoints_withProperties.readUser(this.userPayload.getUsername());
        response.then().log().all();
        Assert.assertEquals(response.getStatusCode(),200);
        logger.info("********* User Info Displayed***********");
    }

    @Test(priority=3)
    public void testUpdateUser()
    {
        logger.info("********* Updating User Data ***********");
        //update data using payload
        userPayload.setFirstName(faker.name().firstName());
        userPayload.setLastName(faker.name().lastName());
        userPayload.setEmail(faker.internet().safeEmailAddress());

        Response response = UserEndPoints_withProperties.updateUser(this.userPayload.getUsername(), userPayload);
        response.then().log().all();
        response.then().log().body().statusCode(200);
        //or
        Assert.assertEquals(response.getStatusCode(), 200);

        //checking data after update
        Response responseAfterUpdate = UserEndPoints_withProperties.readUser(this.userPayload.getUsername());
        Assert.assertEquals(responseAfterUpdate.getStatusCode(),200);

        logger.info("********* User Info Updated ***********");

    }

    @Test(priority=4)
    public void testDeleteUserByName()
    {
        logger.info("********* Deleting User ***********");
        Response response = UserEndPoints_withProperties.deleteUser(this.userPayload.getUsername());
        Assert.assertEquals(response.getStatusCode(), 200);
        logger.info("********* User Deleted ***********");

    }

}
