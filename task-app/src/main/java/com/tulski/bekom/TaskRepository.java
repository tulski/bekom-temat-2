package com.tulski.bekom;

import java.util.List;
import java.util.UUID;

public interface TaskRepository {

    Task save(Task task);

    Task findById(UUID id);

    List<Task> findByDescription(String description);

    List<Task> findAll();

    void deleteById(UUID id);

    void deleteAll();

}
