package com.example.book;

import java.util.concurrent.CompletableFuture;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

  private final CommandGateway commandGateway;

  public BookController(CommandGateway commandGateway) {
    this.commandGateway = commandGateway;
  }

  @PostMapping("/{id}")
  public CompletableFuture<String> createBook(@PathVariable String id) {
    return commandGateway.send(new CreateBookCommand(id));
  }

  @PutMapping("/{id}")
  public CompletableFuture<String> updateBook(@PathVariable String id, @RequestParam String name) {
    return commandGateway.send(new UpdateBookCommand(id, name));
  }
}
