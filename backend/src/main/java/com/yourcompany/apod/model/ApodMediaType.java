package com.yourcompany.apod.model;

public enum ApodMediaType {
    IMAGE,
    VIDEO,
    OTHER;

    public static ApodMediaType fromString(String value) {
        if (value == null) {
            return OTHER;
        }
        switch (value.toLowerCase()) {
            case "image":
                return IMAGE;
            case "video":
                return VIDEO;
            default:
                return OTHER;
        }
    }
}
