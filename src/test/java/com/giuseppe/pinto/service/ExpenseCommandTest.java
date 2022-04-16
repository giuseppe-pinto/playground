package com.giuseppe.pinto.service;

import com.giuseppe.pinto.domain.Transaction;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class ExpenseCommandTest {


  @Test
  void everyoneOwesSomethingToAUser() {

    ExpenseCommand underTest = new ExpenseCommand();

    List<Transaction> transactions =
            underTest.execute("EXPENSE u1 1000 4 u1 u2 u3 u4 EQUAL");

    List<Transaction> expected = List.of(
            new Transaction("u4", "u1", new BigDecimal("250.00")),
            new Transaction("u3", "u1", new BigDecimal("250.00")),
            new Transaction("u2", "u1", new BigDecimal("250.00"))
    );

    assertThat(transactions).containsAll(expected);
  }
}