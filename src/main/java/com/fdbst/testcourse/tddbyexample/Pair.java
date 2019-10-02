package com.fdbst.testcourse.tddbyexample;

import java.util.Objects;

/**
 * Classe Pair
 * <p>
 * Essa classe é responsável por...
 *
 * @author Felipe Di Bernardi S Thiago
 */
public class Pair {

    private final String from;
    private final String to;

    public Pair(String from, String to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair pair = (Pair) o;
        return Objects.equals(from, pair.from) &&
                Objects.equals(to, pair.to);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}
