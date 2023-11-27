package ru.eqour.urfulibraryrest.repository;

import ru.eqour.urfulibraryrest.exception.ReaderNotFoundException;
import ru.eqour.urfulibraryrest.model.Reader;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MemoryReaderRepository implements ReaderRepository {

    private final Map<Integer, Reader> readerMap;
    private final AtomicInteger id;

    public MemoryReaderRepository() {
        this.readerMap = Collections.synchronizedMap(new LinkedHashMap<>());
        id = new AtomicInteger(0);
    }

    public MemoryReaderRepository(Map<Integer, Reader> readerMap) {
        this.readerMap = readerMap;
        int maxId = this.readerMap.keySet().stream()
                .max(Integer::compareTo)
                .orElse(0);
        id = new AtomicInteger(maxId);
    }

    @Override
    public Reader create(Reader reader) {
        reader.setId(id.incrementAndGet());
        readerMap.put(reader.getId(), reader);
        return reader;
    }

    @Override
    public List<Reader> findAll() {
        return new ArrayList<>(readerMap.values());
    }

    @Override
    public Reader findById(int id) {
        Reader reader = readerMap.get(id);
        if (reader != null) {
            return reader;
        } else {
            throw new ReaderNotFoundException();
        }
    }

    @Override
    public Reader update(int id, Reader reader) {
        Reader storedReader = readerMap.get(id);
        if (storedReader != null) {
            reader.setId(id);
            readerMap.put(id, reader);
            return reader;
        } else {
            throw new ReaderNotFoundException();
        }
    }

    @Override
    public void delete(int id) {
        Reader reader = readerMap.get(id);
        if (reader != null) {
            readerMap.remove(id, reader);
        } else {
            throw new ReaderNotFoundException();
        }
    }
}
