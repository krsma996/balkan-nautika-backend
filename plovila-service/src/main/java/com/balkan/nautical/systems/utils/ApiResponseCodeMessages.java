package com.balkan.nautical.systems.utils;


public class ApiResponseCodeMessages {

    // Success
    public static final String CODE_200 = "OK";
    public static final String CODE_200_UPDATED = "Resource updated successfully";
    public static final String CODE_200_DELETED = "Resource deleted successfully";
    public static final String CODE_201 = "Resource created successfully";
    public static final String CODE_202 = "Request accepted for processing";
    public static final String CODE_204 = "No content";

    // Client errors
    public static final String CODE_400 = "Bad request, invalid input or parameters";
    public static final String CODE_401 = "Unauthorized";
    public static final String CODE_403 = "Forbidden";
    public static final String CODE_404 = "Resource could not be found";
    public static final String CODE_405 = "Method not allowed";
    public static final String CODE_406 = "Not acceptable";
    public static final String CODE_409 = "Conflict";
    public static final String CODE_415 = "Unsupported media type";
    public static final String CODE_422 = "Unprocessable entity";
    public static final String CODE_429 = "Too many requests";

    // Server errors
    public static final String CODE_500 = "Internal error, something went wrong";
    public static final String CODE_501 = "Not implemented";
    public static final String CODE_502 = "Bad gateway";
    public static final String CODE_503 = "Service unavailable";
    public static final String CODE_504 = "Gateway timeout";
}