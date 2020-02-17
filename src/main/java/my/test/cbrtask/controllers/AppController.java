package my.test.cbrtask.controllers;

import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AppController<T, U> {
  ResponseEntity save(U item);

  ResponseEntity edit(U item);

  ResponseEntity delete(Long id);

  ResponseEntity<U> getItem(Long id);

  ResponseEntity<List<U>> getItemList();
}
