package com.tulski.bekom;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
class Task {

    enum Status {
        TODO, IN_PROGRESS, DONE
    }

    @Id
    private UUID id;
    private String description;
    @Enumerated(EnumType.STRING)
    private Status status;

    Task(String description) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.status = Status.TODO;
    }

}
