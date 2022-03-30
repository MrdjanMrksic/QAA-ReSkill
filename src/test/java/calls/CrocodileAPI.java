package calls;

import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import data.models.common.CrocodileRequest;
import data.models.common.CrocodileResponse;
import data.models.authentication.LoginRequest;
import data.models.authentication.LoginResponse;
import data.models.common.EmptyResponse;

public class CrocodileAPI {

    public static LoginResponse login(LoginRequest loginRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.LOGIN, loginRequest), LoginResponse.class);
    }

    public static CrocodileResponse[] getPublicCrocodileResponse() {
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.PUBLIC_CROCODILES), CrocodileResponse[].class);
    }

    public static CrocodileResponse[] getMyCrocodilesResponse(String accessToken){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.PRIVATE_CROCODILES, accessToken),CrocodileResponse[].class);
    }

    public static CrocodileResponse createCrocodileResponse (String accessToken, CrocodileRequest crocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.PRIVATE_CROCODILES, accessToken, crocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse getCrocodileById(String accessToken, int id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.SINGLE_CROCODILE(id), accessToken), CrocodileResponse.class);
    }

    public static CrocodileResponse putCrocodileById(String accessToken, int id, CrocodileRequest crocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.put(ApiEndpoints.PUT_PATCH_DELETE_CROCODILE(id), accessToken, crocodileRequest), CrocodileResponse.class);
    }

    public static CrocodileResponse patchCrocodileById(String accessToken, int id, CrocodileRequest crocodileRequest){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.patch(ApiEndpoints.PUT_PATCH_DELETE_CROCODILE(id), accessToken, crocodileRequest), CrocodileResponse.class);
    }

    public static EmptyResponse deleteCrocodileById (String accessToken, int id){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.delete(ApiEndpoints.PUT_PATCH_DELETE_CROCODILE(id), accessToken), EmptyResponse.class);
    }
}