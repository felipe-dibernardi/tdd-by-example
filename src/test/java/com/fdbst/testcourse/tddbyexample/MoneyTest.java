package com.fdbst.testcourse.tddbyexample;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


/**
 * Classe MoneyTest
 * <p>
 * Essa classe é responsável por...
 *
 * @author Felipe Di Bernardi S Thiago
 */
public class MoneyTest {

    @Test
    void testMultiplication() {
        Money dollar = Money.dollar(5);
        assertEquals(Money.dollar(10), dollar.times(2));
        assertEquals(Money.dollar(15), dollar.times(3));

        Money franc = Money.franc(5);
        assertEquals(Money.franc(10), franc.times(2));
        assertEquals(Money.franc(15), franc.times(3));
    }

    @Test
    void testEquality() {
        assertEquals(Money.dollar(5), Money.dollar(5));
        assertEquals(Money.franc(5), Money.franc(5));
        assertNotEquals(Money.dollar(5), Money.dollar(10));
        assertNotEquals(Money.dollar(5), Money.franc(5));
    }

    @Test
    void testCurrency() {
        assertEquals("USD", Money.dollar(1).currency());
        assertEquals("CHF", Money.franc(1).currency());
    }

    @Test
    void testSimpleAddition() {
        Money five = Money.dollar(5);
        Expression sum = five.plus(five);
        Bank bank = new Bank();
        Money reduced = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(10), reduced);
    }

    @Test
    void testPlusReturnSum() {
        Money five = Money.dollar(5);
        Expression result = five.plus(five);
        Sum sum = (Sum) result;
        assertEquals(five, sum.augmend);
        assertEquals(five, sum.addmend);
    }

    @Test
    void testReduceSum() {
        Expression sum = new Sum(Money.dollar(3), Money.dollar(4));
        Bank bank = new Bank();
        Money result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(7), result);
    }

    @Test
    void testReduceMoney() {
        Bank bank = new Bank();
        Money result = bank.reduce(Money.dollar(1), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    void testReduceMoneyDifferentCurrency() {
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Money result = bank.reduce(Money.franc(2), "USD");
        assertEquals(Money.dollar(1), result);
    }

    @Test
    void testIdentityRate() {
        assertEquals(1, new Bank().rate("USD", "USD"));
        assertEquals(1, new Bank().rate("CHF", "CHF"));
    }

    @Test
    void testMixedAddition() {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression result = bank.reduce(fiveDollars.plus(tenFrancs), "USD");
        assertEquals(Money.dollar(10), result);
    }

    @Test
    void testSumPlusMoney() {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveDollars, tenFrancs).plus(fiveDollars);
        Expression result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(15), result);
    }

    @Test
    void testSumTimes() {
        Expression fiveDollars = Money.dollar(5);
        Expression tenFrancs = Money.franc(10);
        Bank bank = new Bank();
        bank.addRate("CHF", "USD", 2);
        Expression sum = new Sum(fiveDollars, tenFrancs).times(2);
        Expression result = bank.reduce(sum, "USD");
        assertEquals(Money.dollar(20), result);
    }
}
