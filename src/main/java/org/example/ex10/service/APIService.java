package org.example.ex10.service;

public class APIService {
    private static final APIService instance = new APIService();

    public static APIService getInstance() {
        return instance;
    }

    private APIService() {}

    public String callAPI() {
        return "Hello World";
    }
}
