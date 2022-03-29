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
    public int crocodileId;

    public CrocodileRequest crocodileRequest = new CrocodileRequest(
            "Mrdjan",
            "M",
            "2012-12-12"
    );

    public CrocodileRequest putCrocodileRequest = new CrocodileRequest(
            "MrdjanPut",
            "F",
            "2015-12-12"

    );

    public CrocodileRequest patchCrocodileRequest = new CrocodileRequest(
    );

    public CrocodileResponse createCrocodileResponse = new CrocodileResponse();

    @BeforeClass
    public void beforeClass() {
        //set baseURI for tests
        RestAssured.baseURI = ConfigSetup.getBaseUrl();

        //create access token for tests
        accessToken = CrocodileAPI.login(new LoginRequest(ConfigSetup.getUser(), ConfigSetup.getPassword())).getAccess();

        //create crocodile for tests
        createCrocodileResponse = CrocodileAPI.createCrocodileResponse(accessToken, crocodileRequest);

        //get crocodileID for tests
        crocodileId = createCrocodileResponse.getId();
    }

}
