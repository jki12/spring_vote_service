package com.example.vote;

import java.util.Objects;

public class Util {
    private static String salt;

    private Util() {
    }

    public static String crypto(String plain) {
        String pw = plain;

        // encoding..

        return pw;
    }

    public static int hash(Object o) {
        return Objects.hash(o);
    }
}
