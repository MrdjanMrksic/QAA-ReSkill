package test.suites;

import calls.CrocodileAPI;
import data.models.common.CrocodileResponse;
import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.asserts.CrocodileAsserts;
import test.common.TestBase;

public class CrocodileTests extends TestBase {


    public CrocodileAsserts crocodileAsserts = new CrocodileAsserts();

    @Test(groups = "priority")
    @Description("Test login functionality and assert that access token is not empty")
    public void loginTest(){
        Assert.assertFalse(accessToken.isEmpty(), "Access Token is empty");
    }

    @Test(groups = "priority")
    @Description("Test create crocodile functionality and assert that crocodile is created")
    public void createCrocodileTest(){
        Assert.assertNotNull(crocodileId, "Crocodile has not been created successfully");
        crocodileAsserts.assertCrocodileResponse(createCrocodileResponse, crocodileRequest);
    }

    @Test(groups = "priority")
    @Description("Test getting of the list of public crocodiles and assert that all objects are not empty")
    public void getListOfPublicCrocodilesTest() {
        CrocodileResponse[] getPublicCrocodileResponse = CrocodileAPI.getPublicCrocodileResponse();

        crocodileAsserts.assertListOfCrocodiles(getPublicCrocodileResponse);
    }

    @Test(groups = "priority")
    @Description("Test getting of the list of private crocodiles and assert that all objects are not empty")
    public void getListOfMyCrocodilesTest() {
        CrocodileResponse[] getMyCrocodileResponse = CrocodileAPI.getMyCrocodilesResponse(accessToken);

        crocodileAsserts.assertListOfCrocodiles(getMyCrocodileResponse);
    }

    @Test(groups = "priority")
    @Description("Test getting a private crocodiles by ID and assert that response is same as the request")
    public void getMyCrocodileByIDTest(){
        CrocodileResponse getMyCrocodileByIDResponse = CrocodileAPI.getCrocodileById(accessToken, crocodileId);

        crocodileAsserts.assertCrocodileResponse(getMyCrocodileByIDResponse, crocodileRequest);
    }

    @Test(groups = "priority")
    @Description("Test editing a private crocodiles by ID and assert that response is same as the request")
    public void putMyCrocodileByIDTest(){
        CrocodileResponse putMyCrocodileByIDResponse = CrocodileAPI.putCrocodileById(accessToken, crocodileId, putCrocodileRequest);
        crocodileAsserts.assertCrocodileResponse(putMyCrocodileByIDResponse, putCrocodileRequest);
    }

    @Test(groups = "priority")
    @Description("Test patching a private crocodiles by ID and assert that changed field is the same in response as is in request")
    public void patchMyCrocodileByIDTest(){
        CrocodileResponse patchMyCrocodileByIDResponse = CrocodileAPI.patchCrocodileById(accessToken, crocodileId, patchCrocodileRequest);
        Assert.assertEquals(patchMyCrocodileByIDResponse.getName(), patchCrocodileRequest.getName());
    }

    @Test(dependsOnGroups = "priority")
    @Description("Test deleting a private crocodiles by ID and assert that response is null and crocodile is successfully deleted")
    public void deleteMyCrocodileByIDTest(){
        CrocodileResponse deleteMyCrocodileByIDResponse = CrocodileAPI.deleteCrocodileById(accessToken, crocodileId);

        Assert.assertNull(deleteMyCrocodileByIDResponse);
    }

}
