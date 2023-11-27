package ru.eqour.urfulibraryrest.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eqour.urfulibraryrest.exception.ReaderNotFoundException;
import ru.eqour.urfulibraryrest.model.Reader;
import ru.eqour.urfulibraryrest.repository.ReaderRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/v1/readers")
public class ReaderController {

    private ReaderRepository repository;

    @Autowired
    public void setRepository(ReaderRepository repository) {
        this.repository = repository;
    }

    @PostMapping()
    public ResponseEntity<Reader> create(@Valid @RequestBody Reader reader) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(repository.create(reader));
    }

    @GetMapping()
    public ResponseEntity<List<Reader>> findAll() {
        return ResponseEntity.of(Optional.of(repository.findAll()));
    }

    @GetMapping("{readerId}")
    public ResponseEntity<Reader> findById(@PathVariable int readerId) {
        return ResponseEntity.of(Optional.of(repository.findById(readerId)));
    }

    @PutMapping("{readerId}")
    public ResponseEntity<Reader> update(@PathVariable int readerId, @Valid @RequestBody Reader reader) {
        return ResponseEntity.of(Optional.of(repository.update(readerId, reader)));
    }

    @DeleteMapping("{readerId}")
    public ResponseEntity<Void> delete(@PathVariable int readerId) {
        repository.delete(readerId);
        return ResponseEntity.noContent()
                .build();
    }

    @ExceptionHandler(ReaderNotFoundException.class)
    public ResponseEntity<Void> handleReaderNotFoundException() {
        return ResponseEntity.notFound()
                .build();
    }
}
