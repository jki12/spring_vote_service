package com.example.vote;

import java.util.Objects;

public class Util {
    private Util() {
    }

    public static int hash(Object o) {
        return Objects.hash(o);
    }
}
