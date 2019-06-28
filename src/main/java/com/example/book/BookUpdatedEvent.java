package com.example.book;

public class BookUpdatedEvent {

  private final String id;

  private final String name;

  public BookUpdatedEvent(String id, String name) {
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
