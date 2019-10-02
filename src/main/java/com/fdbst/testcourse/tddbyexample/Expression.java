package com.fdbst.testcourse.tddbyexample;

/**
 * Interface Expression
 * <p>
 * Essa intereface é responsável por...
 *
 * @author Felipe Di Bernardi S Thiago
 */
public interface Expression {

    Money reduce(Bank bank, String to);

    Expression plus(Expression addend);

    Expression times(int multiplier);
}
