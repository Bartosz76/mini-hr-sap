package bm.app.minihrsap.model;

import lombok.Getter;

import java.time.LocalDate;

/**
 * DTO serves as a transfer object that is taken from the outside of the application and sent from the application in
 * both cases undergoing a process of mapping either into or from an entity.
 * I can add annotations for validation in a DTO (in an entity that already has a lot of annotations, for example
 * related to mapping, it would cause the excess of annotations).
 */
@Getter
public class EmployeeDto {

    private String firstName;
    private String lastName;
    private boolean active;
    private LocalDate created;

}
