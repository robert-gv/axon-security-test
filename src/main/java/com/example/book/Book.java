package com.example.book;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.security.access.prepost.PreAuthorize;

@Aggregate
public class Book {

  @AggregateIdentifier
  private String id;

  private String name;

  public Book() {
  }

  @CommandHandler
  public Book(CreateBookCommand command) {
    AggregateLifecycle.apply(new BookCreatedEvent(command.getId()));
  }

  @CommandHandler
  @PreAuthorize("hasPermission(#command.id, 'book', {'update'})")
  public void handle(UpdateBookCommand command) {
    AggregateLifecycle.apply(new BookUpdatedEvent(command.getId(), command.getName()));
  }

  @EventSourcingHandler
  public void on(BookCreatedEvent event) {
    id = event.getId();
  }

  @EventSourcingHandler
  public void on(BookUpdatedEvent event) {
    name = event.getName();
  }
}
