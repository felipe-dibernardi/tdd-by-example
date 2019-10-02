package com.fdbst.testcourse.tddbyexample;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe Bank
 * <p>
 * Essa classe é responsável por...
 *
 * @author Felipe Di Bernardi S Thiago
 */
public class Bank {

    private Map<Pair, Integer> rateMap = new HashMap<>();

    public Money reduce(Expression source, String toCurrency) {
        return source.reduce(this, toCurrency);
    }

    public int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }
        return rateMap.get(new Pair(from, to));
    }

    public void addRate(String from, String to, int rate) {
        rateMap.put(new Pair(from, to), rate);
    }
}
