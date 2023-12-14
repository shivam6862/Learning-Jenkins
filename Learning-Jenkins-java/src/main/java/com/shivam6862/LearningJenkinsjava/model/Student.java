package com.shivam6862.LearningJenkinsjava.model;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class Student {
    private UUID id;
    @NotBlank
    private String name;
    @NotBlank
    private String email;

    public Student(@JsonProperty("id") UUID id, @JsonProperty("name") String name,
            @JsonProperty("email") String email) {
        this.id = (id == null) ? UUID.randomUUID() : id;
        this.name = name;
        this.email = email;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
