package com.giuseppe.pinto.service;

import com.giuseppe.pinto.domain.Transaction;

import java.util.List;

public interface Command
{
  List<Transaction> execute(String input);
}
