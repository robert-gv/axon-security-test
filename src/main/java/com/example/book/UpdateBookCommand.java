package com.example.book;

import org.axonframework.modelling.command.TargetAggregateIdentifier;

public class UpdateBookCommand {

  @TargetAggregateIdentifier
  private final String id;

  private final String name;

  public UpdateBookCommand(String id, String name) {
    this.id = id;
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
