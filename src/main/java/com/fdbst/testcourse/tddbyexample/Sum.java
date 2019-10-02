package com.fdbst.testcourse.tddbyexample;

/**
 * Classe Sum
 * <p>
 * Essa classe é responsável por...
 *
 * @author Felipe Di Bernardi S Thiago
 */
public class Sum implements Expression {

    Expression augmend;

    Expression addmend;

    public Sum(Expression augmend, Expression addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        int amount = augmend.reduce(bank, to).amount + addmend.reduce(bank, to).amount;
        return new Money(amount, to);
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addmend);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augmend.times(multiplier), addmend.times(multiplier));
    }
}
