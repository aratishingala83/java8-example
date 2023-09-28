## Core Java 8

This module contains articles about Java 8 core features

### Relevant Articles: 
- [New Features in Java 8](https://www.baeldung.com/java-8-new-features)
- [Guide to Java 8 groupingBy Collector](https://www.baeldung.com/java-groupingby-collector)
- [Strategy Design Pattern in Java 8](https://www.baeldung.com/java-strategy-pattern)
- [Guide to Java 8 Comparator.comparing()](https://www.baeldung.com/java-8-comparator-comparing)
- [Guide to the Java 8 forEach](https://www.baeldung.com/foreach-java)
- [Introduction to Spliterator in Java](https://www.baeldung.com/java-spliterator)
- [Finding Min/Max in an Array with Java](https://www.baeldung.com/java-array-min-max)
- [Internationalization and Localization in Java 8](https://www.baeldung.com/java-8-localization)
- [Generalized Target-Type Inference in Java](https://www.baeldung.com/java-generalized-target-type-inference)
- [[More -->]](/core-java-modules/core-java-8-2)


import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.util.EntityUtils;

public class HttpClientWithCookies {
    public static void main(String[] args) {
        try {
            // Create a HttpClient with a cookie store
            CookieStore cookieStore = new BasicCookieStore();
            HttpClient httpClient = new DefaultHttpClient();
            httpClient.getParams().setParameter("http.protocol.handle-redirects", false); // Disable automatic redirects

            // Attach the cookie store to the HttpClient
            ((DefaultHttpClient) httpClient).setCookieStore(cookieStore);

            // Initial request to obtain cookies
            HttpGet initialRequest = new HttpGet("https://example.com");
            HttpResponse initialResponse = httpClient.execute(initialRequest);

            // Extract cookies from the response
            for (org.apache.http.cookie.Cookie cookie : cookieStore.getCookies()) {
                System.out.println("Cookie: " + cookie.getName() + " = " + cookie.getValue());

                // Optionally, you can modify the cookie if needed
                if (cookie.getName().equals("exampleCookie")) {
                    BasicClientCookie updatedCookie = new BasicClientCookie(cookie.getName(), "newCookieValue");
                    updatedCookie.setDomain(cookie.getDomain());
                    updatedCookie.setPath(cookie.getPath());
                    cookieStore.addCookie(updatedCookie);
                }
            }

            // Create a new request and set the extracted cookies
            HttpGet newRequest = new HttpGet("https://example.com/another-page");

            // Execute the new request with the updated cookies
            HttpResponse newResponse = httpClient.execute(newRequest);

            // Handle the new response as needed
            String responseBody = EntityUtils.toString(newResponse.getEntity());
            System.out.println("Response: " + responseBody);

            // Don't forget to close the HttpClient when done
            httpClient.getConnectionManager().shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

