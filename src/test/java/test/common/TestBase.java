package test.common;

import calls.CrocodileAPI;
import data.models.common.CrocodileResponse;
import data.models.authentication.LoginRequest;
import data.models.common.CrocodileRequest;
import environment.ConfigSetup;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class TestBase {

    public String accessToken;

    @BeforeClass
    public void beforeClass() {
        //set baseURI for tests
        RestAssured.baseURI = ConfigSetup.getBaseUrl();

        //create access token for tests
        accessToken = CrocodileAPI.login(new LoginRequest(ConfigSetup.getUser(), ConfigSetup.getPassword())).getAccess();
    }

}
