package de.neuefische;

public enum OrderStatus {
    OPEN("The order is open"),
    IN_PROGRESS("The order is in progress"),
    DELIVERED("The order is delivered"),
    ;

    private final String description;

    OrderStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}


