package com.mycompany.utils.client;


import java.io.IOException;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseClient {



    public static String readProperties(String property) throws IOException {
        System.getProperties().load(ClassLoader.getSystemResourceAsStream("config.properties"));
        return System.getProperty(property);
    }



    protected RequestSpecification baseSpec() throws IOException {
        return new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri(readProperties("baseURL"))
                .build();


    }

    public static void main(String[] args) throws IOException {
        System.out.println(BaseClient.readProperties("baseURL"));
    }



}
