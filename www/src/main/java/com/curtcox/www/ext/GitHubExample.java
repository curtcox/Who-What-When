package com.curtcox.www.ext;

import java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.*;
import com.github.scribejava.apis.GitHubApi;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.*;
import com.github.scribejava.core.oauth.OAuth20Service;

class GitHubExample {

    // Replace these with your client id and secret
    static final String clientId = "";
    static final String clientSecret = "";

    private static final String PROTECTED_RESOURCE_URL = "https://api.github.com/user";
    private static final String CALLBACK = "https://github.com/curtcox/Who-What-When";
    final String secretState = "secret" + new Random().nextInt(999_999);
    final Scanner in = new Scanner(System.in, "UTF-8");
    OAuth20Service service;

    private GitHubExample() { }

    void createService() {
        service = new ServiceBuilder(clientId)
                .apiSecret(clientSecret)
                .callback(CALLBACK)
                .build(GitHubApi.instance());
    }

    String authorizationURL() {
        return service.getAuthorizationUrl(secretState);
    }

    URI getAuthorization() {
        openBrowser(authorizationURL());
        println("And paste the authorization code here");
        final String code = read();
        try {
            return new URI(code);
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    void openBrowser(String url) {
        try {
            Desktop.getDesktop().browse(new URI(url));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    void validateSecretState(String value) {
        if (!secretState.equals(value)) {
            String message = "Expected = " + secretState + " Got = " + value;
            throw new RuntimeException(message);
        }
    }

    OAuth2AccessToken getAccessToken(String code) throws Exception {
        println("Trading the Authorization Code for an Access Token...");
        final OAuth2AccessToken accessToken = service.getAccessToken(code);
        println("Got the Access Token!");
        println("(The raw response looks like this: " + accessToken.getRawResponse() + "')");
        println();
        return accessToken;
    }

    void getProtectedResource(OAuth2AccessToken accessToken) throws Exception {
        println("Now we're going to access a protected resource...");
        final OAuthRequest request = new OAuthRequest(Verb.GET, PROTECTED_RESOURCE_URL);
        service.signRequest(accessToken, request);
        try (Response response = service.execute(request)) {
            println("Got it! Lets see what we found...");
            println();
            println("" + response.getCode());
            println(response.getBody());
        }
        println();
        println("That's it man! Go and build something awesome with ScribeJava! :)");
    }

    String read() {
        System.out.print(">>");
        return in.nextLine();
    }

    static void println() {
        println("");
    }

    static void println(String message) {
        System.out.println(message);
    }

    String code(URI uri) {
        var query = uri.getQuery();
        return query.substring(query.indexOf('=') + 1,query.indexOf('&'));
    }

    String check(URI uri) {
        var query = uri.getQuery();
        return query.substring(query.lastIndexOf("=") + 1);
    }

    void auth() throws Exception {
        createService();
        final URI uri = getAuthorization();
        validateSecretState(check(uri));
        final OAuth2AccessToken accessToken = getAccessToken(code(uri));
        getProtectedResource(accessToken);
    }

    public static void main(String[] args) throws Exception {
        new GitHubExample().auth();
    }
}
