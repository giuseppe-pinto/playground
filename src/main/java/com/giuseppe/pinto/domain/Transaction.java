package com.giuseppe.pinto.domain;

import java.math.BigDecimal;
import java.util.Objects;

public class Transaction {

  private final String userIdFrom;
  private final String userIdTo;
  private final BigDecimal amount;

  public Transaction(String userIdFrom, String userIdTo, BigDecimal amount) {
    this.userIdFrom = userIdFrom;
    this.userIdTo = userIdTo;
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Transaction that = (Transaction) o;
    return Objects.equals(userIdFrom, that.userIdFrom) && Objects.equals(userIdTo, that.userIdTo) && Objects.equals(amount, that.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(userIdFrom, userIdTo, amount);
  }

  @Override
  public String toString() {
    return "Transaction{" +
            "userIdFrom='" + userIdFrom + '\'' +
            ", userIdTo='" + userIdTo + '\'' +
            ", amount=" + amount +
            '}';
  }
}
