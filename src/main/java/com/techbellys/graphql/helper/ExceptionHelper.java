package com.techbellys.graphql.helper;

public class ExceptionHelper {
    public static RuntimeException throwResoureNotFoundException() {
        return new RuntimeException("Resource not found !!");
    }
}
