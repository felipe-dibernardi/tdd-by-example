package com.fdbst.testcourse.tddbyexample;

/**
 * Classe Sum
 * <p>
 * Essa classe é responsável por...
 *
 * @author Felipe Di Bernardi S Thiago
 */
public class Sum implements Expression {

    Money augmend;

    Money addmend;

    public Sum(Money augmend, Money addmend) {
        this.augmend = augmend;
        this.addmend = addmend;
    }

    public Money reduce(String to) {
        return new Money(augmend.amount + addmend.amount, to);
    }

}
