package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.CrocodileRequest;
import data.models.CrocodileResponse;
import data.models.LoginRequest;
import data.models.LoginResponse;
import io.restassured.response.Response;

public class CrocodileAPI {

    public static LoginResponse login(LoginRequest loginRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("auth/token/login/", loginRequest), LoginResponse.class);
    }

    public static CrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("public/crocodiles/"), CrocodileResponse[].class);
    }

    public static CrocodileResponse[] getMyCrocodilesResponse(String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/", accessToken),CrocodileResponse[].class);
    }

    public static CrocodileResponse createCrocodileResponse (String accessToken, CrocodileRequest crocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("my/crocodiles/", accessToken, crocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse getCrocodileByID (String accessToken, int ID){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/"+ID, accessToken), CrocodileResponse.class);
    }

    public static CrocodileResponse putCrocodileByID (String accessToken, int ID, CrocodileRequest crocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put("my/crocodiles/"+ID+"/", accessToken, crocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse patchCrocodileByID (String accessToken, int ID, CrocodileRequest crocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch("my/crocodiles/"+ID+"/", accessToken, crocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse deleteCrocodileByID (String accessToken, int ID){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete("my/crocodiles/"+ID+"/", accessToken), CrocodileResponse.class);
    }
}
