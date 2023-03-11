package libs;

import org.aeonbits.owner.ConfigFactory;

public class TestData {
    public static ConfigHiddenProperties configHiddenProperties = ConfigFactory.create(ConfigHiddenProperties.class);

    public final static String VALID_lOGIN = System.getProperty("login", configHiddenProperties.login());
    public final static String VALID_PASSWORD = System.getProperty("password", configHiddenProperties.password());
    public final static String REGION = System.getProperty("region", configHiddenProperties.region());
    public final static String CITY = System.getProperty("city", configHiddenProperties.city());
    public final static String STREET = System.getProperty("street", configHiddenProperties.street());
    public final static String BUILDING = System.getProperty("building", configHiddenProperties.building());
    public final static String APPT = System.getProperty("appt", configHiddenProperties.appt());


}
