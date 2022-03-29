package test.asserts;

import data.models.common.CrocodileRequest;
import data.models.common.CrocodileResponse;
import org.testng.asserts.SoftAssert;

public class CrocodileAsserts {

    public SoftAssert softAssert = new SoftAssert();

    public void assertCrocodileResponse(CrocodileResponse crocodileResponse, CrocodileRequest crocodileRequest) {
        softAssert.assertEquals(crocodileResponse.getName(), crocodileRequest.getName(), "Name didn't match");
        softAssert.assertEquals(crocodileResponse.getDateOfBirth(), crocodileRequest.getDateOfBirth(), "date of birth didn't match");
        softAssert.assertEquals(crocodileResponse.getSex(), crocodileRequest.getSex(), "Sex didn't match");
        softAssert.assertAll();
    }

    public void assertListOfCrocodiles(CrocodileResponse[] getPublicCrocodileResponse) {
        for(int i = 0; i < getPublicCrocodileResponse.length; i++) {
            softAssert.assertFalse(getPublicCrocodileResponse[i].getName().isEmpty(), "Name is not empty");
        }
        softAssert.assertAll();
    }


}
