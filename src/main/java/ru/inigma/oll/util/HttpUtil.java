package ru.inigma.oll.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpUtil {
    public static int requestKey() throws IOException {
        //CloseableHttpClient client = HttpClients.createDefault();
        //HttpPost post = new HttpPost("Url");
        // some params here...

        //HttpResponse response = client.execute(post);
        // get key from response
        // return key
        return 123;
    }
}
