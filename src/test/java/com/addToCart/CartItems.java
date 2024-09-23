package com.addToCart;


/*
Record is a Java class that's used to represent data records, such as those returned from a database or remote service.
It only gives us the read-only access for those records.
There is no need to define the Getters and Setters java methods for this class
 */
public record CartItems(String title, String description, Double price) {

}
