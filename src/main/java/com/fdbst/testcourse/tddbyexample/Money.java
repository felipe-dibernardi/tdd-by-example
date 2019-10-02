package com.fdbst.testcourse.tddbyexample;

/**
 * Classe Money
 * <p>
 * Essa classe é responsável por...
 *
 * @author Felipe Di Bernardi S Thiago
 */
public class Money implements Expression {

    protected int amount;

    protected String currency;

    public Money(int amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    protected String currency() {
        return currency;
    }

    @Override
    public Expression times(int multiplier) {
        return new Money(amount * multiplier, currency);
    }

    public static Money dollar(int amount) {
        return new Money(amount, "USD");
    }

    public static Money franc(int amount) {
        return new Money(amount, "CHF");
    }

    public boolean equals(Object object) {
        Money money = (Money) object;

        return amount == money.amount
                && currency == money.currency;
    }

    @Override
    public Money reduce(Bank bank, String to) {
        return new Money(amount / bank.rate(this.currency, to), to);
    }

    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
}
