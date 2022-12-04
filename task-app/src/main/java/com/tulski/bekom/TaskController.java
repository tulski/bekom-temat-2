package com.tulski.bekom;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/task")
@RequiredArgsConstructor
class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping
    public Collection<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("/{id}")
    public Task getTask(@PathVariable UUID id) {
        return taskRepository.findById(id);
    }

    @PostMapping("/search")
    public Collection<Task> getTasksByDescription(@RequestParam("description") String description) {
        return taskRepository.findByDescription(description);
    }

    @PostMapping
    public UUID createTask(@RequestBody String name) {
        var task = new Task(name);
        taskRepository.save(task);
        return task.getId();
    }

}
