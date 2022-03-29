package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import data.models.common.CrocodileRequest;
import data.models.common.CrocodileResponse;
import data.models.authentication.LoginRequest;
import data.models.authentication.LoginResponse;

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

    public static CrocodileResponse getCrocodileById(String accessToken, int id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get("my/crocodiles/"+id, accessToken), CrocodileResponse.class);
    }

    public static CrocodileResponse putCrocodileById(String accessToken, int id, CrocodileRequest crocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put("my/crocodiles/"+id+"/", accessToken, crocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse patchCrocodileById(String accessToken, int id, CrocodileRequest crocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch("my/crocodiles/"+id+"/", accessToken, crocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse deleteCrocodileById (String accessToken, int id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete("my/crocodiles/"+id+"/", accessToken), CrocodileResponse.class);
    }
}