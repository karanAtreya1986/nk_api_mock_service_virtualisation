package org.mock.api;

import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;


public class APIMocks {

    public static void getDummyUser(){
        //create stub for get user:
        stubFor(get(urlEqualTo("/api/users"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\n" +
                                "\"name\": \"Naveen\"\n" +
                                "}")));
    }


    public static void getDummyUserWithQueryParams(){
        //create stub for get user:
        stubFor(get(urlPathEqualTo("/api/users"))
                .withQueryParam("param", equalTo("value"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"result\": \"user is searched\"}")));
    }


    public static void createDummyUser(){
        stubFor(post(urlEqualTo("/api/users"))
                .withHeader("Content-Type", WireMock.equalTo("application/json"))
                .withRequestBody(equalToJson("{\"name\": \"Naveen\"}"))
                .willReturn(aResponse()
                        .withStatus(201)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"message\": \"user is created\"}")));
    }


    public static void deleteDummyUser(){
        stubFor(delete(urlEqualTo("/api/users"))
                .willReturn(aResponse()
                        .withStatus(204)));
    }


    public static void getWithQueryParams() {
        stubFor(get(urlPathEqualTo("/api/users"))
                .withQueryParam("param", equalTo("value")) // Query parameter
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody("{\"result\": \"Query success!\"}")));
    }


}
