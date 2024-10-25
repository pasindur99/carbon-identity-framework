package org.wso2.carbon.identity.mgt.endpoint.util.client;

import org.apache.http.conn.ssl.AllowAllHostnameVerifier;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HTTPClientUtils {
    private HTTPClientUtils() {
    }

    public static CloseableHttpClient createClientWithCustomVerifier() {
        boolean isIgnoreHostnameVerification = Boolean.parseBoolean(System.
                getProperty("org.wso2.ignoreHostnameVerification"));
        if (isIgnoreHostnameVerification) {
            return HttpClients.custom().setHostnameVerifier(new AllowAllHostnameVerifier()).build();
        } else {
            return HttpClients.createDefault();
        }
    }
}
