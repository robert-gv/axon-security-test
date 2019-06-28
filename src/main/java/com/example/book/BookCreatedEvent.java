package com.example.book;

public class BookCreatedEvent {

  private final String id;

  public BookCreatedEvent(String id) {
    this.id = id;
  }

  public String getId() {
    return id;
  }
}
