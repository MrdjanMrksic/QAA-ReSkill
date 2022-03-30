package constants;

public class ApiEndpoints {

    //public crocodiles
    public static final String PUBLIC_CROCODILES = "public/crocodiles/";

    //private crocodiles
    public static final String PRIVATE_CROCODILES = "my/crocodiles/";
    public static String SINGLE_CROCODILE(int id) {return PRIVATE_CROCODILES + id;}
    public static String PUT_PATCH_DELETE_CROCODILE(int id) {return PRIVATE_CROCODILES + id + "/";}

    //login
    public static final String LOGIN = "auth/token/login/";
}
