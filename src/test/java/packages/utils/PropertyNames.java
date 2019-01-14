package packages.utils;

import static packages.utils.PropertyHelper.getProperty;


public class PropertyNames {

    public static final String UI_URL = getProperty("base.url");
    public static final String API_URL = getProperty("api.url");

    public static final String ENDPOINT_COUNTRY_SERVICE = getProperty("country.service");

    private PropertyNames() {
    }
}
