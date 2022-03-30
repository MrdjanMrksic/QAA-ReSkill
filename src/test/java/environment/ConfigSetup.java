package environment;

public class ConfigSetup extends ConfigReader{
    public static String getBaseUrl(){return getValue("BASE_URL");}
    public static String getUser(){return getValue("BASE_USER");}
    public static String getPassword(){return getValue("DEFAULT_PASSWORD");}
}
