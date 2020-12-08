package com.sapan.java.j8;

import java.util.function.Function;

public class MyFunction {
    public static void main(String[] args) {
        Function<String, String> upper = String::new;
        upper.apply("Sapan");
    }


}
