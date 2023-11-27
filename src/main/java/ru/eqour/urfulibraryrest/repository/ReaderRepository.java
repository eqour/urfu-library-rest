package ru.eqour.urfulibraryrest.repository;

import org.springframework.stereotype.Repository;
import ru.eqour.urfulibraryrest.exception.ReaderNotFoundException;
import ru.eqour.urfulibraryrest.model.Reader;

import java.util.List;

@Repository
public interface ReaderRepository {

    Reader create(Reader reader);
    List<Reader> findAll();
    Reader findById(int id) throws ReaderNotFoundException;
    Reader update(int id, Reader reader) throws ReaderNotFoundException;
    void delete(int id) throws ReaderNotFoundException;
}
