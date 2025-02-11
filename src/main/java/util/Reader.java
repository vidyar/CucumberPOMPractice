package util;

import java.util.ResourceBundle;

public class Reader {
    static ResourceBundle rb = ResourceBundle.getBundle("bookings");

    public static String getUrl()
    {
        return rb.getString("url");
    }
}
