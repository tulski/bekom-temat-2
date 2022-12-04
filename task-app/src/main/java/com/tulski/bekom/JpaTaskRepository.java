package com.tulski.bekom;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
@Transactional
class JpaTaskRepository implements TaskRepository {

    private final EntityManager entityManager;

    @Override
    public Task save(Task task) {
        entityManager.persist(task);
        return task;
    }

    @Override
    public Task findById(UUID id) {
        return (Task) entityManager.createQuery("select t from Task t where t.id = :id")
                .setParameter("id", id)
                .getSingleResult();
    }

    @Override
    public List<Task> findByDescription(String description) {
        return (List<Task>) entityManager.createNativeQuery("select * from task where description = '" + description + "'", Task.class)
                .getResultList();
    }

    @Override
    public List<Task> findAll() {
        return entityManager.createQuery("select t from Task t", Task.class).getResultList();
    }

    @Override
    public void deleteById(UUID id) {
        entityManager.remove(findById(id));
    }

    @Override
    public void deleteAll() {
        entityManager.createQuery("delete from Task").executeUpdate();
    }


}
