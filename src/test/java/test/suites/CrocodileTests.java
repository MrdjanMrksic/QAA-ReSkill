package test.suites;

import calls.CrocodileAPI;
import data.models.CrocodileResponse;
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
        Assert.assertNotNull(crocodileID, "Crocodile has not been created successfully");
        crocodileAsserts.assertResponseRequestEquality(createCrocodileResponse, crocodileRequest);
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
        CrocodileResponse getMyCrocodileByIDResponse = CrocodileAPI.getCrocodileByID(accessToken, crocodileID);

        crocodileAsserts.assertResponseRequestEquality(getMyCrocodileByIDResponse, crocodileRequest);
    }

    @Test(groups = "priority")
    @Description("Test editing a private crocodiles by ID and assert that response is same as the request")
    public void putMyCrocodileByIDTest(){
        CrocodileResponse putMyCrocodileByIDResponse = CrocodileAPI.putCrocodileByID(accessToken, crocodileID, putCrocodileRequest);
        crocodileAsserts.assertResponseRequestEquality(putMyCrocodileByIDResponse, putCrocodileRequest);
    }

    @Test(groups = "priority")
    @Description("Test patching a private crocodiles by ID and assert that changed field is the same in response as is in request")
    public void patchMyCrocodileByIDTest(){
        CrocodileResponse patchMyCrocodileByIDResponse = CrocodileAPI.patchCrocodileByID(accessToken, crocodileID, patchCrocodileRequest);
        Assert.assertEquals(patchMyCrocodileByIDResponse.getName(), patchCrocodileRequest.getName());
    }

    @Test(dependsOnGroups = "priority")
    @Description("Test deleting a private crocodiles by ID and assert that response is null and crocodile is successfully deleted")
    public void deleteMyCrocodileByIDTest(){
        CrocodileResponse deleteMyCrocodileByIDResponse = CrocodileAPI.deleteCrocodileByID(accessToken, crocodileID);

        Assert.assertNull(deleteMyCrocodileByIDResponse);
    }

}
