package data.provider;
import data.models.common.CrocodileRequest;

public class CrocodileProvider {
    public static CrocodileRequest preparePostCrocodileRequest(){
        CrocodileRequest crocodileRequest = new CrocodileRequest();
        crocodileRequest.setName("Mrdjan Crocodile");
        crocodileRequest.setDateOfBirth("1992-03-20");
        crocodileRequest.setSex("M");

        return crocodileRequest;
    }

    public static CrocodileRequest preparePutCrocodileRequest(){
        CrocodileRequest crocodileRequest = new CrocodileRequest();
        crocodileRequest.setName("Mrdjan Crocodile");
        crocodileRequest.setDateOfBirth("1992-03-20");
        crocodileRequest.setSex("M");

        return crocodileRequest;
    }
}
