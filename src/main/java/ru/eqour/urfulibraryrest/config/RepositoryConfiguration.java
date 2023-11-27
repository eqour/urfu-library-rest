package ru.eqour.urfulibraryrest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.eqour.urfulibraryrest.model.Reader;
import ru.eqour.urfulibraryrest.repository.MemoryReaderRepository;

import java.util.Collections;
import java.util.LinkedHashMap;

@Configuration
public class RepositoryConfiguration {

    @Bean
    public MemoryReaderRepository memoryReaderRepository() {
        return new MemoryReaderRepository(Collections.synchronizedMap(new LinkedHashMap<>(){{
            put(1, new Reader(1,
                    "Иван",
                    "Иванов",
                    "Иванович",
                    "9412856324",
                    "г. Екатеринбург, ул. Лесная, д. 14",
                    "+79125846635")
            );
            put(2, new Reader(2,
                    "Артём",
                    "Яшин",
                    null,
                    "9415658545",
                    "г. Екатеринбург, ул. Уютная, д. 7, кв. 35",
                    "+79125846635")
            );
            put(3, new Reader(3,
                    "Дарья",
                    "Кузнецова",
                    "Романовна",
                    "9415663388",
                    "г. Екатеринбург, ул. 1 мая, д. 17, кв. 3",
                    null)
            );
            put(4, new Reader(4,
                    "Денис",
                    "Костин",
                    "Артёмович",
                    "9217685487",
                    "г. Екатеринбург, ул. Строителей, д. 22",
                    "+79605007757")
            );
            put(5, new Reader(5,
                    "Николай",
                    "Николаев",
                    null,
                    "9217685487",
                    "г. Екатеринбург, ул. Новая, д. 11, кв. 77",
                    null)
            );
        }}));
    }
}
