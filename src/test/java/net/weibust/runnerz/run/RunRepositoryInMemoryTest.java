package net.weibust.runnerz.run;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RunRepositoryInMemoryTest {

    RunRepositoryInMemory repository;

    @BeforeEach
    void setUp() {
        repository = new RunRepositoryInMemory();

        repository.create(new Run(1,
                 "Monday Morning Run", 
                 LocalDateTime.now(), 
                 LocalDateTime.now().plus(30, ChronoUnit.MINUTES), 
                 3, 
                 Location.INDOOR,
                 null));

        repository.create(new Run(2,
                 "Wednesday Evening Run", 
                 LocalDateTime.now(), 
                 LocalDateTime.now().plus(60, ChronoUnit.MINUTES), 
                 6, 
                 Location.INDOOR,
                 null));
    }

    @Test
    void shouldFindAllRuns() {
        List<Run> runs = repository.findAll();
        assertEquals(2, runs.size(), "Should have returned 2 runs");
    }

    // Todo
    // add remaining tests Dan wrote 
}
