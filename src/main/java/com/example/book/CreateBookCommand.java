package com.example.book;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class CreateBookCommand {

  @TargetAggregateIdentifier
  private final String id;

  public CreateBookCommand(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
