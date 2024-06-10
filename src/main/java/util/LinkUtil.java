package util;

import java.net.HttpURLConnection;
import java.net.URL;

public final class LinkUtil {

    private LinkUtil() {
        throw new UnsupportedOperationException("Cannot instantiate LinkUtil");
    }


    public static int getResponseCode(String url) {

        HttpURLConnection httpURLConnection = null;
        int responseCode = 0;
        try {
            URL link = new URL(url);
            httpURLConnection = (HttpURLConnection) link.openConnection();
            httpURLConnection.setConnectTimeout(3000); // Set connection timeout to 3 seconds
            httpURLConnection.connect();

            responseCode = httpURLConnection.getResponseCode();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (null == httpURLConnection)
                httpURLConnection.disconnect();
        }
        return responseCode;
    }
}
