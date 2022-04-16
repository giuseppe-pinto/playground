package com.giuseppe.pinto.service;

import com.giuseppe.pinto.domain.Transaction;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;

public class ExpenseCommand implements Command {
  @Override
  public List<Transaction> execute(String input) {

    List<String> split = List.of(input.split(" "));

    String userIdTo = split.get(1);

    BigDecimal cash = new BigDecimal(split.get(2));
    int numberOfUsers = Integer.parseInt(split.get(3));

    int id = findIdOfWayOfSplit(split);

    List<String> usersIdFrom = split.subList(4, id);

    if ("EQUAL".equals(split.get(id))) {
      BigDecimal divided = cash.divide(new BigDecimal(numberOfUsers), 2, RoundingMode.HALF_UP);
      return usersIdFrom
              .stream()
              .filter(userIdFrom -> !userIdFrom.equals(userIdTo))
              .map(userIdFrom -> new Transaction(userIdFrom, userIdTo, divided))
              .collect(Collectors.toList());
    } else {
      return emptyList();
    }
  }


  private int findIdOfWayOfSplit(List<String> split) {

    for (int i = 0; i < split.size(); i++) {
      if ("EQUAL".equals(split.get(i)) || "EXACT".equals(split.get(i)) || "PERCENT".equals(split.get(i))) {
        return i;
      }
    }

    return -1;
  }
}
