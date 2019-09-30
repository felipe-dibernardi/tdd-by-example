package com.fdbst.testcourse.tddbyexample;

/**
 * Classe Bank
 * <p>
 * Essa classe é responsável por...
 *
 * @author Felipe Di Bernardi S Thiago
 */
public class Bank {
    public Money reduce(Expression source, String toCurrency) {
        return source.reduce(toCurrency);
    }
}
